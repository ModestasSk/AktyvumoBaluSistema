package vgtu.laboratorinis6;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class KursuSarasas extends AppCompatActivity {
    private String studento_numeris = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kursu_sarasas);
        String studento_nr = this.getIntent().getStringExtra("stud_nr");
        GautiDuomenis duom  = new GautiDuomenis();
        duom.execute(studento_nr);
        }

    private class GautiDuomenis extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... nr) {
            String rezultatas = "";
            try{
                String studento_nr = nr[0];
                studento_numeris = nr[0];
                HttpURLConnection s = (HttpURLConnection) new URL("http://192.168.1.170:8080/api/kontroleris/studentas="+studento_nr+".html").openConnection();
                BufferedReader bufRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String outStr;
                while((outStr = bufRead.readLine()) !=null){
                    rezultatas+=outStr;
                }
                bufRead.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rezultatas;
        }



        protected void onPostExecute(String result) {
            try {
                JSONArray json = new JSONArray(result);
                final ArrayList<String> list = new ArrayList<String>();
                final ArrayList<Integer> ids = new ArrayList();
                for (int i = 0; i < json.length(); i++) {
                    JSONObject c = json.getJSONObject(i);
                    String id = c.getString("trumpasPav");
                    String pavadinimas = c.getString("pavadinimas");
                    String bendras = "("+id+") "+pavadinimas;
                    list.add(bendras);
                }
                ListView w = (ListView)findViewById(R.id.l_kursu_sarasas);
                ArrayAdapter adapter = new ArrayAdapter(KursuSarasas.this,android.R.layout.simple_list_item_1,list);
                w.setAdapter(adapter);

                w.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String[] strings = list.get(position).split(" ");
                        String kursas = strings[0].substring(1,strings[0].length()-1);
                        prisijungimas(getWindow().getDecorView().findViewById(android.R.id.content),kursas);

                    }
                });
            }
            catch(Exception e){}
            }
        public void prisijungimas(View view, String kursas){

            Intent naujas = new Intent(view.getContext(),KursoUzduotys.class);
            naujas.putExtra("stud_nr", studento_numeris);
            naujas.putExtra("kurso_nr", kursas);
            startActivity(naujas);
        }
    }
}

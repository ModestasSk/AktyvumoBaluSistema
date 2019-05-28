package vgtu.laboratorinis6;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class KursoUzduotys extends AppCompatActivity {
    private String studento_numeris;
    private String uzduoties_numeris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurso_uzduotys);
        String kurso_nr = this.getIntent().getStringExtra("kurso_nr");
        studento_numeris = this.getIntent().getStringExtra("stud_nr");
        KursoUzduotys.GautiDuomenis duom  = new KursoUzduotys.GautiDuomenis();
        duom.execute(kurso_nr);
    }

    private class GautiDuomenis extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... nr) {
            String rezultatas = "";
            try{
                String kurso_nr = nr[0];
                HttpURLConnection s = (HttpURLConnection) new URL("http://192.168.1.170:8080/api/kontroleris/kursas="+kurso_nr+".html").openConnection();
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
            //Toast.makeText(KursoUzduotys.this,result,Toast.LENGTH_LONG).show();
            try {
                JSONArray json = new JSONArray(result);
                final ArrayList<String> list = new ArrayList<String>();
                final ArrayList<Integer> ids = new ArrayList<Integer>();
                int counter = 0;
                for (int i = 0; i < json.length(); i++) {
                    JSONObject c = json.getJSONObject(i);
                    String statusas = c.getString("statusas");
                    if(statusas.equals("matomas")) {

                        String pavadinimas = c.getString("pavadinimas");
                        //Toast.makeText(KursoUzduotys.this,pavadinimas,Toast.LENGTH_SHORT).show();
                        String id = c.getString("kodas");
                        //  String bendras = "("+id+") "+pavadinimas;

                        list.add(pavadinimas);
                        ids.add(counter, new Integer(id));
                        counter++;
                    }
                }
                ListView w = (ListView)findViewById(R.id.l_uzduociu_sarasas);
                ArrayAdapter adapter = new ArrayAdapter(KursoUzduotys.this,android.R.layout.simple_list_item_1,list);
                w.setAdapter(adapter);

                w.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        uzduoties_numeris = ""+ids.get(position);
                        System.out.println(uzduoties_numeris);
                        prisijungimas(getWindow().getDecorView().findViewById(android.R.id.content));

                    }
                });
            }
            catch(Exception e){}
        }
        public void prisijungimas(View view){
            Intent naujas = new Intent(view.getContext(),Uzduotis.class);
            naujas.putExtra("stud_nr", studento_numeris);
            naujas.putExtra("uzd_nr", uzduoties_numeris);
            startActivity(naujas);

        }
    }
}

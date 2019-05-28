package vgtu.laboratorinis6;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Uzduotis extends AppCompatActivity {
    String studento_numeris = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uzduotis);
        String uzduoties_nr = (""+this.getIntent().getStringExtra("uzd_nr"));
        studento_numeris = this.getIntent().getStringExtra("stud_nr");
        Uzduotis.GautiDuomenis duom  = new Uzduotis.GautiDuomenis();
        duom.execute(uzduoties_nr);

    }
    private class GautiDuomenis extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... nr) {
            String rezultatas = "";
            try{
                String uzduoties_nr = nr[0];
                HttpURLConnection s = (HttpURLConnection) new URL("http://192.168.1.170:8080/api/kontroleris/uzduotis="+uzduoties_nr+".html").openConnection();
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
                JSONObject json = new JSONObject(result);
                final ArrayList<String> list = new ArrayList<String>();
                final ArrayList<Integer> ids = new ArrayList<Integer>();
                JSONObject c = json;
                String pavadinimas = c.getString("pavadinimas");
                String aprasymas = c.getString("aprasymas");
                String atsiskaitymoData = c.getString("atsiskaitymoData");
                JSONArray a = c.getJSONArray("ikelimai");
              //Toast.makeText(Uzduotis.this,spavadinimas,Toast.LENGTH_SHORT).show();
                TextView tUzduotisVardas = (TextView)findViewById(R.id.uzduotis_vardas);
                tUzduotisVardas.setText(pavadinimas);
                TextView tUzduotisAprasymas = (TextView)findViewById(R.id.uzduotis_aprasymas);
                tUzduotisAprasymas.setText(aprasymas);
                TextView tUzduotisData = (TextView)findViewById(R.id.uzduotis_data);
                tUzduotisData.setText(atsiskaitymoData);
            }
            catch(Exception e){}
        }
    }
}

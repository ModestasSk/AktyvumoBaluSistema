package vgtu.laboratorinis6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void prisijungimas(View view){
        EditText stud_nr = (EditText)findViewById(R.id.l_stud_nr);
        String nr = stud_nr.getText().toString();
        if(nr.length()==8) {
            Intent naujas = new Intent(this, KursuSarasas.class);
            naujas.putExtra("stud_nr", nr);
            startActivity(naujas);
        }
        else
            Toast.makeText(MainActivity.this,"Netinkamas numeris",Toast.LENGTH_SHORT).show();
    }
}

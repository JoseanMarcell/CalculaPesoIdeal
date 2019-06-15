package com.example.calculapesoideal;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 // Declarndo as variaveis no txt

                RadioButton masculino = findViewById(R.id.rbmasculino);

                EditText altura = findViewById(R.id.txtaltura);
                EditText peso = findViewById(R.id.txtpeso);
                TextView imc = findViewById(R.id.txtimc);
                TextView pesoideal = findViewById(R.id.txtpesoideal);
                TextView ideal = findViewById(R.id.txtpesoideal);


                double alt =  Double.parseDouble(altura.getText().toString());
                double pes =  Double.parseDouble(peso.getText().toString());
                double valpeso =  Double.parseDouble(peso.getText().toString());
                double ideal_masculino = alt - 100 - ((150 - alt)/4);
                double ideal_feminino = alt - 100 - ((150 - alt)/2);

                if (masculino.isChecked()) {
                    ideal.setText("Peso Ideal: " + ideal_masculino + " Kg.");
                } else {
                    ideal.setText("Peso Ideal: " + ideal_feminino + " Kg.");
                }


                double IMC = pes / (alt*alt);

                //double pesoidel = Double.parseDouble(IMC.getText().toString());

                if (IMC <= 18.4) {
                    imc.setText("Abaixo do Peso");
                } else if ((IMC >= 18.5) && (IMC <= 24.9)) {
                    imc.setText("Peso Normal");
                } else if ((IMC >= 25) && (IMC <= 29.9)) {
                    imc.setText("Sobrepeso");
                } else if ((IMC >= 30) && (IMC <= 34.9)) {
                    imc.setText("Obesidade Grau 1");
                } else if ((IMC >= 35) && (IMC <= 39.9)) {
                    imc.setText("Obesidade Grau 2");
                } else if (IMC >= 40) {
                    imc.setText("Acima do peso");
                }



                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

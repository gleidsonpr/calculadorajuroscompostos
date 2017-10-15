package br.com.viana.gleidson.calculadorajuroscompostos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Switch swTempo = (Switch) findViewById(R.id.swTempo); // initiate Switch
        swTempo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    swTempo.setText("Anos");
                }
                else{
                    swTempo.setText("Meses");
                }
            }
        });

        final Switch swTempoJuros = (Switch) findViewById(R.id.swTempoJuros); // initiate Switch
        swTempoJuros.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    swTempoJuros.setText("Anual");
                }
                else{
                    swTempoJuros.setText("Mensal");
                }
            }
        });


    }
}

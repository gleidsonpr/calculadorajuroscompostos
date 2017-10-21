package br.com.viana.gleidson.calculadorajuroscompostos;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
                    CalcularJuros();
                }
                else{
                    swTempo.setText("Meses");
                    CalcularJuros();
                }
            }
        });

        final Switch swTempoJuros = (Switch) findViewById(R.id.swTempoJuros); // initiate Switch
        swTempoJuros.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    swTempoJuros.setText("Anual");
                    CalcularJuros();
                }
                else{
                    swTempoJuros.setText("Mensal");
                    CalcularJuros();
                }
            }
        });


        final EditText etInicial =(EditText)findViewById(R.id.etInicial);

        etInicial.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CalcularJuros();

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });


        final EditText etMensal =(EditText)findViewById(R.id.etMensal);

        etMensal.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CalcularJuros();

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        final EditText etTempo =(EditText)findViewById(R.id.etTempo);

        etTempo.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CalcularJuros();

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        final EditText etJuros =(EditText)findViewById(R.id.etJuros);

        etJuros.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CalcularJuros();

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });


    }


    private  void exibirInfo(GanhoJuros ganho) {
        AlertDialog alerta;

        LayoutInflater li = getLayoutInflater();
        View view = li.inflate(R.layout.info, null);
        final TextView tvValorAtualI =(TextView) view.findViewById(R.id.tvValorAtualI);
        tvValorAtualI.setText("R$"+ganho.getValoratual());

        final TextView tvMesI =(TextView) view.findViewById(R.id.tvMesI);
        tvMesI.setText(obterNomeMes(ganho.getMesdata().get(Calendar.MONTH))+"/"+ganho.getMesdata().get(Calendar.YEAR));

        final TextView tvValorGanhoJurosI =(TextView) view.findViewById(R.id.tvValorGanhoJurosI);
        tvValorGanhoJurosI.setText("R$"+ganho.getValorganho());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" ");
        builder.setView(view);

        builder.setPositiveButton("Fechar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });

        alerta = builder.create();
        alerta.show();
    }
    public String obterNomeMes(int mes){
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
                "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        return meses[mes];
    }
    public  void CalcularJuros(){
        final EditText etInicial =(EditText)findViewById(R.id.etInicial);
        final EditText etMensal =(EditText)findViewById(R.id.etMensal);

        final EditText etTempo =(EditText)findViewById(R.id.etTempo);
        final EditText etJuros =(EditText)findViewById(R.id.etJuros);

        final TextView tvMensagemFinal =(TextView) findViewById(R.id.tvMensagemFinal);
        tvMensagemFinal.setText("");
        final TextView tvMensagemFinalAcumulado =(TextView) findViewById(R.id.tvMensagemFinalAcumulado);
        tvMensagemFinalAcumulado.setText("");

        final Switch swTempo = (Switch) findViewById(R.id.swTempo);
        final Switch swTempoJuros = (Switch) findViewById(R.id.swTempoJuros);


        boolean valido=true;

        if(etInicial.getText().toString().isEmpty()||etJuros.getText().toString().isEmpty()||etTempo.getText().toString().isEmpty()||etMensal.getText().toString().isEmpty())

        {
            valido=false;
        }

        if(valido) {
            double C= Double.parseDouble(etInicial.getText().toString());
            double I=Double.parseDouble(etJuros.getText().toString());
            double T=Double.parseDouble(etTempo.getText().toString());
            double valMensal =Double.parseDouble(etMensal.getText().toString());

            if (swTempo.isChecked()) {

                T = T * 12;
            }
            if (swTempoJuros.isChecked()) {
                I = I / 12;
            }

            I = I / 100;
            final ArrayList<GanhoJuros> lista = new ArrayList<GanhoJuros>();
            double valorInicial = C;
            double depositoMensal = valMensal;
            double txJuro = I;
            double lucroMes = 0;


            for (int i = 1; i <= T; i++) {

                lucroMes = valorInicial * txJuro;
                GanhoJuros ganhoJuros = new GanhoJuros();
                ganhoJuros.setValoratual("" + Double.valueOf(String.format(Locale.US, "%.2f", valorInicial)));
                ganhoJuros.setValorganho("" + Double.valueOf(String.format(Locale.US, "%.2f", (lucroMes))));
                ganhoJuros.setMesatual("" + i);

                Calendar dataDaAplicacao = Calendar.getInstance();
                dataDaAplicacao.add(Calendar.MONTH,i);
                    ganhoJuros.setMesdata(dataDaAplicacao);

                lista.add(ganhoJuros);

                if (i == T) {
                    tvMensagemFinal.setText("Rentabilidade mensal no final: R$" + Double.valueOf(String.format(Locale.US, "%.2f", (lucroMes))));
                    tvMensagemFinalAcumulado.setText("Acumulado: R$" + Double.valueOf(String.format(Locale.US, "%.2f", (valorInicial + lucroMes + depositoMensal))));
                }
                valorInicial += lucroMes + depositoMensal;
            }
            ListaAdapterGanhoJuros adapterPiada = new ListaAdapterGanhoJuros(this, lista);
            ListView listView = (ListView) findViewById(R.id.lvGanho);
            listView.setAdapter(adapterPiada);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    GanhoJuros ganho= lista.get(position);
                    exibirInfo(ganho);

                }
            });

        }
        else{
              tvMensagemFinal.setText("Verifique os campos");

        }

    }
}

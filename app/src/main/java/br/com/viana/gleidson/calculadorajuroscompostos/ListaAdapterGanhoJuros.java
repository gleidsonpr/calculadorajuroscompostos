package br.com.viana.gleidson.calculadorajuroscompostos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gleidson on 14/10/2017.
 */

public class ListaAdapterGanhoJuros extends ArrayAdapter<GanhoJuros> {


    private Context context;
    private ArrayList<GanhoJuros> lista;


    public ListaAdapterGanhoJuros(Context context, ArrayList<GanhoJuros> lista) {
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GanhoJuros ganhoSelecionado = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.activity_calculado, null);
        TextView tvValorGanhoJuros = (TextView) convertView.findViewById(R.id.tvValorGanhoJuros);
        TextView tvValorAtual = (TextView) convertView.findViewById(R.id.tvValorAtual);
        TextView tvMes = (TextView) convertView.findViewById(R.id.tvMes);

        tvValorGanhoJuros.setText("R$"+ganhoSelecionado.getValorganho());
        tvValorAtual.setText("R$"+ganhoSelecionado.getValoratual());
        tvMes.setText(ganhoSelecionado.getMesatual());
        return convertView;
    }
}
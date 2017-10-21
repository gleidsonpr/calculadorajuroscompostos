package br.com.viana.gleidson.calculadorajuroscompostos;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by gleidson on 14/10/2017.
 */

public class GanhoJuros {
    private String valorganho;
    private String valoratual;
    private String mesatual;
    private Calendar Mesdata;



    public GanhoJuros() {

    }

    public Calendar getMesdata() {
        return Mesdata;
    }

    public void setMesdata(Calendar mesdata) {
        Mesdata = mesdata;
    }

    public String getValorganho() {
        return valorganho;
    }

    public void setValorganho(String valorganho) {
        this.valorganho = valorganho;
    }

    public String getValoratual() {
        return valoratual;
    }

    public void setValoratual(String valoratual) {
        this.valoratual = valoratual;
    }

    public String getMesatual() {
        return mesatual;
    }

    public void setMesatual(String mesatual) {
        this.mesatual = mesatual;
    }
}

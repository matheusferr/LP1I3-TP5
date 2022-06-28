package com.company;

import com.company.util.InputValidator;

public class AmostraTemperatura {
    private final InputValidator inputValidator = new InputValidator();
    private int numSeq = 0;
    private Data data;
    private Hora hora;
    private float valor;

    public int getNumSeq() {
        return this.numSeq;
    }

    public String getData() {
        return this.data.getFormattedDate();
    }

    public void setData(int a, int b, int c) {
        this.data = new Data(a, b, c);
    }

    public void setData() {
        Data data = new Data();

        data.setAno();

        data.setMes();

        data.setDia();

        this.data = data;
    }

    public String getHora() {
        return hora.getFormattedHour();
    }

    public void setHora(int a, int b, int c) {
        this.hora = new Hora(a, b, c);
    }

    public void setHora() {
        int hour = inputValidator.validInt("Hora: ");

        while (hour > 24) {
            hour = inputValidator.validInt("Hora: ");
        }

        int min = inputValidator.validInt("Minuto: ");

        while (min > 60) {
            min = inputValidator.validInt("Minuto: ");
        }

        int sec = inputValidator.validInt("Segundo: ");

        while (sec > 60) {
            sec = inputValidator.validInt("Segundo: ");
        }

        this.hora = new Hora(hour, min, sec);
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor() {
        this.valor = this.inputValidator.unvalidatedFloat("Valor: ");

        this.numSeq++;
    }

    public AmostraTemperatura() {
        this.setData();

        this.setHora();

        this.setValor();
    }

    public AmostraTemperatura(Data data, Hora hora, float valor) {
        this.data = data;

        this.hora = hora;

        this.valor = valor;
    }

    public AmostraTemperatura(int ano, int mes, int dia, int hora, int minuto, int segundo, float valor) {
        this.data = new Data(dia, mes, ano);

        this.hora = new Hora(hora, minuto, segundo);

        this.valor = valor;
    }
}

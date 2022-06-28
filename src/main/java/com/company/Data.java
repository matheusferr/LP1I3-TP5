package com.company;

import com.company.util.InputValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    private final InputValidator inputValidator = new InputValidator();

    public boolean bissexto() {
        return this.ano % 4 == 0;
    }

    public int getDia() {
        return dia;
    }

    public void setDia() {
        int maxDays = this.mes % 2 == 0 ? 30 : 31;

        if (this.mes == 2)
            maxDays = this.bissexto() ? 29 : 28;

        int day = this.inputValidator.validInt("Dia: ");

        while (day < 0 || day > maxDays) {
            day = this.inputValidator.validInt("Dia: ");
        }

        this.dia = day;
    }

    public void setDia(int dia) {
        int maxDays = this.mes % 2 == 0 ? 30 : 31;

        if (this.mes == 2)
            maxDays = this.bissexto() ? 29 : 28;

        if(dia < 0 || dia > maxDays)
            throw new IllegalArgumentException();

        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes() {
        int month = this.inputValidator.validInt("Mês: ");

        while (month < 0 || month > 12) {
            month = this.inputValidator.validInt("Mês: ");
        }

        this.mes = month;
    }

    public void setMes(int mes) {
        if(mes < 0 || mes > 12)
            throw new IllegalArgumentException();

        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno() {
        int year = this.inputValidator.validInt("Ano: ");

        while (year < 0) {
            year = this.inputValidator.validInt("Ano: ");
        }

        this.ano = year;
    }

    public void setAno(int ano) {
        if(ano < 0)
            throw new IllegalArgumentException();

        this.ano = ano;
    }

    public String getFormattedDate() {
        return String.format("%02d/%02d/%02d", this.dia, this.mes, this.ano);
    }

    public String getFormattedDateMonth() {
        LocalDate date = LocalDate.of(this.ano, this.mes, this.dia);

        String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());

        return String.format("%02d/%s/%d", this.dia, month, this.ano);
    }

    public int getDiasTranscorridos() {
        return LocalDate.of(this.ano, this.mes, this.dia).getDayOfYear();
    }

    public void apresentaDataAtual() {
        LocalDate date = LocalDate.of(this.ano, this.mes, this.dia);

        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
    }

    public Data(int dia, int mes, int ano) {
        this.setAno(ano);
        this.setMes(mes);
        this.setDia(dia);
    }

    public Data() {
        LocalDate date = LocalDate.now();

        this.dia = date.getDayOfMonth();
        this.mes = date.getMonthValue();
        this.ano = date.getYear();
    }
}
/*
 @author Matheus Ferreira da Costa
 * Renomear as propriedades e métodos da classe Data, deixando-os de acordo com o padrão UML (métodos getters e setters).
 * Crie a classe AmostraTemperatura conforme especificado abaixo (2,0):
 */
package com.company;

public class Ex1 {
    private static void printTemperature(AmostraTemperatura aT){
        System.out.println(aT.getNumSeq());

        System.out.println(aT.getData());

        System.out.println(aT.getHora());

        System.out.println(aT.getValor());
    }

    public static void main(String[] args) {
        AmostraTemperatura t1 = new AmostraTemperatura(2022, 1, 1, 12, 0, 0, 0);

        printTemperature(t1);

        AmostraTemperatura t2 = new AmostraTemperatura();

        printTemperature(t2);

        t1.setData();

        t1.setHora();

        t1.setValor();

        printTemperature(t1);
    }
}

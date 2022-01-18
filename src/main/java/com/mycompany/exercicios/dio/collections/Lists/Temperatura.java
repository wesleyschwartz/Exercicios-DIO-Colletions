package com.mycompany.exercicios.dio.collections.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Faça um programa que receba a temperatura média dos 6 primeiros meses do ano
 * e armazene-as em uma lista. OK
 *
 * Após isto, calcule a média semestral das temperaturas e mostre todas as
 * temperaturas acima desta média, e em que mês elas ocorreram (mostrar o mês
 * por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
 *
 * @author wesle
 */
public class Temperatura {

    public static void main(String args[]) {
        Scanner ler = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<>();
        List<String> meses = new ArrayList<>();
        meses.add("Janeiro");
        meses.add("Fevereiro");
        meses.add("Março");
        meses.add("Abril");
        meses.add("Maio");
        meses.add("Junho");
        Double soma = 0d, temperatura1 = 0d;
        boolean check = true;
        for (int i = 0; i < 6; i++) {
            System.out.println("Digite a " + (i + 1) + "º  temperatura");
            while (check) {
                String sTemperatura = ler.next();
                try {
                    temperatura1 = Double.parseDouble(sTemperatura);
                    check = false;
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Por favor insira valores corretos");
                }
            }
            check = true;
            temperaturas.add(temperatura1);
            soma += temperatura1;
        }
        double media = soma / temperaturas.size();

        System.out.println(String.format("A média da temperatura é %.2f", media));
        System.out.println("As temperaturas ácima da média foram : ");
        for (int i = 0;
                i < 6; i++) {
            if (temperaturas.get(i) > media) {
                System.out.print("\t" + meses.get(i) + " foi: " + temperaturas.get(i));
            }
        }
    }
}

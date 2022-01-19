/*
Faça um programa que simule um lançamento de dados.
Lance o dado 100 vezes e armazene.
Depois, mostre quantas vezes cada valor foi inserido.
 */
package com.mycompany.exercicios.dio.collections.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author wesle
 */
public class Desafio {

    public static void main(String[] args) {
        List<Integer> valores = new ArrayList<>();
        Random gerarDado = new Random();
        for (int i = 0; i < 20; i++) {
            int number = gerarDado.nextInt(6) + 1;
            valores.add(number);
        }
        System.out.println(valores);
        int soma1 = 0, soma2 = 0, soma3 = 0, soma4 = 0, soma5 = 0, soma6 = 0;
        for (int i = 0; i < 20; i++) {
            if (valores.get(i) == 1) {
                soma1 += 1;
            } else if (valores.get(i) == 2) {
                soma2 += 1;
            } else if (valores.get(i) == 3) {
                soma3 += 1;
            } else if (valores.get(i) == 4) {
                soma4 += 1;
            } else if (valores.get(i) == 5) {
                soma5 += 1;
            } else if (valores.get(i) == 6) {
                soma6 += 1;
            }
        }
        System.out.println("Número 1 = " + soma1 +" vezes"+ "\n Número 2 = " + soma2 +" vezes" + "\n Número 3 = " + soma3 +" vezes" + "\n Número 4 = " + soma4 +" vezes" + "\n Número 5 = " + soma5 +" vezes" + "\n Número 6 = " + soma6+" vezes");

        System.out.println("\nUtilizando HashMap...");
        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : valores) {
            if (lancamentos.containsKey(resultado)) {
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            } else {
                lancamentos.put(resultado, 1);
            }
        }

        System.out.println("QtdVezes com HashMap ");
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.println("Número: " + entry.getKey() +" foi jogado: "+ entry.getValue() + " vezes");
        }
    }
}

/*
 *
Utilizando listas, faça um programa que faça 5 perguntas para uma
pessoa sobre um crime. As perguntas são:

"Telefonou para a vítima?"

"Esteve no local do crime?"

"Mora perto da vítima?"

"Devia para a vítima?"

"Já trabalhou com a vítima?"

Se a pessoa responder positivamente a 2 questões ela deve ser
classificada como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como
"Assassina". Caso contrário, ela será classificado como "Inocente". */
package com.mycompany.exercicios.dio.collections.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author wesle
 */
public class Assassino {

    public static void main(String args[]) {
        List<String> sim = new ArrayList<>();
        List<String> nao = new ArrayList<>();
        Scanner ler = new Scanner(System.in);

        System.out.println("Telefonou para a vítima? -SIM || NAO-");
        boolean check = true;
        String resposta1;
        while (check) {
            resposta1 = ler.next();
            if (resposta1.equalsIgnoreCase("sim")) {
                sim.add(resposta1);
                check = false;
            } else if (resposta1.equalsIgnoreCase("nao")) {
                nao.add(resposta1);
                check = false;
            } else {
                System.out.println("Resposta não registrada. Tente novamente");
            }
        }

        System.out.println("Esteve no local do crime?");
        check = true;
        while (check) {
            resposta1 = ler.next();
            if (resposta1.equalsIgnoreCase("sim")) {
                sim.add(resposta1);
                check = false;
            } else if (resposta1.equalsIgnoreCase("nao")) {
                nao.add(resposta1);
                check = false;
            } else {
                System.out.println("Resposta não registrada. Tente novamente");
            }
        }
        System.out.println("Mora perto da vítima?");
        check = true;
        while (check) {
            resposta1 = ler.next();
            if (resposta1.equalsIgnoreCase("sim")) {
                sim.add(resposta1);
                check = false;
            } else if (resposta1.equalsIgnoreCase("nao")) {
                nao.add(resposta1);
                check = false;
            } else {
                System.out.println("Resposta não registrada. Tente novamente");
            }
        }
        System.out.println("Devia para a vítima?");
        check = true;
        while (check) {
            resposta1 = ler.next();
            if (resposta1.equalsIgnoreCase("sim")) {
                sim.add(resposta1);
                check = false;
            } else if (resposta1.equalsIgnoreCase("nao")) {
                nao.add(resposta1);
                check = false;
            } else {
                System.out.println("Resposta não registrada. Tente novamente");
            }
        }
        System.out.println("Já trabalhou com a vítima?");
        check = true;
        while (check) {
            resposta1 = ler.next();
            if (resposta1.equalsIgnoreCase("sim")) {
                sim.add(resposta1);
                check = false;
            } else if (resposta1.equalsIgnoreCase("nao")) {
                nao.add(resposta1);
                check = false;
            } else {
                System.out.println("Resposta não registrada. Tente novamente");
            }
        }
        if (sim.size() >= 2) {
            System.out.println("Você é suspeito");
        } else if (sim.size() >= 4) {
            System.out.println("Você é cúmplice");
        } else if (sim.size() >= 5) {
            System.out.println("Você é um assassino!!!");
        } else {
            System.out.println("Inocente.");
        }
    }
}

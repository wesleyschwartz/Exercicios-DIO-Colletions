/*
cada elemento tem uma key e são únicos, podem ser iguais.

 */
package com.mycompany.exercicios.dio.collections.Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author wesle
 */
public class ExemplosMap {

    public static void main(String[] args) {
        /**
         * valores exemplos. modelo = gol - consumo = 16.5km/l modelo = uno -
         * consumo = 19.2 km/l modelo = mobi - consumo = 18.1 km/l modelo = hb20
         * - consumo = 12.7 km/l modelo = kwid - consumo = 20 km/l
         */
        /*FORMAS DE INICIAR UM MAP
    Map carrosPop2021= new HashMap(); // antes do java 5
    Map<String, Double> carrosPop = new HashMap<>(); //Generics(jdk 5);
    HashMap<String, Double>  carrosPop = new HashMap<>();
    Map<Sting, Double> carrosPop2021 = Map.of("Gol", 16.5, "Uno", 19.2, "Mobi", 18.1, "HB20", 12.7, "Kwid", 20.0);
         */
        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        Map<String, Double> carrosPop = new HashMap<>() {
            {
                put("Gol", 16.5);
                put("Uno", 19.2);
                put("Mobi", 18.1);
                put("HB20", 12.7);
                put("Kwid", 20.0);
            }
        };
        System.out.println(carrosPop);
        System.out.println("\n Substitua o consumo do gol por 15,2 km/l: ");
        carrosPop.put("Gol", 15.2);
        System.out.println(carrosPop);

        System.out.println("\n Confira se o modelo Tucson está no dicionário: " + carrosPop.containsKey("Tucson"));

        System.out.println("\nExiba o consumo do uno: " + carrosPop.get("Uno"));

        // NÃO DÁ. System.out.println("Exiba o terceiro modelo adicionado: ");
        System.out.println("\nExiba os modelos: " + carrosPop.keySet());

        System.out.println("\nExiba os consumos dos carros: " + carrosPop.values());

        System.out.println("\nExiba o modelo mais econômico e seu consumo: ");
        Double consumoEficiente = Collections.max(carrosPop.values());
        Set<Map.Entry<String, Double>> entrySet = carrosPop.entrySet();
        String modeloEficiente = "";

        for (Map.Entry<String, Double> entry : entrySet) {
            if (entry.getValue().equals(consumoEficiente)) {
                modeloEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloEficiente + " - " + consumoEficiente);
            }
        }

        System.out.println("\nExiba o modelo menos econômico e seu consumo: ");
        Double menosConsumoEficiente = Collections.min(carrosPop.values());
        String menosModeloEficiente = "";
        for (Map.Entry<String, Double> entry : entrySet) {
            if (entry.getValue().equals(menosConsumoEficiente)) {
                menosModeloEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + menosModeloEficiente + " - " + menosConsumoEficiente);
            }
        }

        System.out.println("\n Exiba a soma dos consumos:");
        Iterator<Double> iterator = carrosPop.values().iterator();
        double soma = 0d;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println("\n Exiba a média dos consumos deste dicionário de carros: " + (soma / carrosPop.size()));

        System.out.println("\n Remova os modelos com consumo igual a 12,7");
        Iterator<Double> iterator1 = carrosPop.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() == 12.7) {
                iterator1.remove();
            }
        }
        System.out.println(carrosPop);

        System.out.println("\nExiba todos os carros na ordem em que foram informados");
        Map<String, Double> carrosPop1 = new LinkedHashMap<>() {
            {
                put("Gol", 16.5);
                put("Uno", 19.2);
                put("Mobi", 18.1);
                put("HB20", 12.7);
                put("Kwid", 20.0);
            }
        };
        System.out.println(carrosPop1);

        System.out.println("\n Exiba o dicionário ordenado pelo modelo: ");
        Map<String, Double> carrosPop2 = new TreeMap<>() {
            {
                put("Gol", 16.5);
                put("Uno", 19.2);
                put("Mobi", 18.1);
                put("HB20", 12.7);
                put("Kwid", 20.0);
            }
        };
        System.out.println(carrosPop2);

        System.out.println("\n Apague o dicionario de carros: ");
        carrosPop2.clear();
        System.out.println(carrosPop2);

        System.out.println("\n Confira se o dicionário está vazio: " + carrosPop2.isEmpty());
    }
}

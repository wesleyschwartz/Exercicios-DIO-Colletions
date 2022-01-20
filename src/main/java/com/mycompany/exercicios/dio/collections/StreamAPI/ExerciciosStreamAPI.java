package com.mycompany.exercicios.dio.collections.StreamAPI;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numeros = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
        /*numeros.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/
        //numeros.stream().forEach(s -> System.out.println(s));
        // numeros.forEach(s -> System.out.println(s));
        numeros.forEach(System.out::println); //QUE TROÇO LEGAL


        System.out.println("Pegue os 5 primiero números e coloque dentro de um set: ");
        //numeros.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::println);
        Set<String> collectSet = numeros.stream()
                .limit(5)
                .collect(Collectors.toSet());
        System.out.println(collectSet);

        System.out.println("Transforme esta lista de String em uma lista de número inteiros");
        /*numeros.stream()
        .map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });*/
        //numeros.stream().map(s -> Integer.parseInt(s));
        List<Integer> numerosInt = numeros.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(numerosInt);

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista ");
        /*List<Integer> ListParesMaioresQue2 = numeros.stream()
                .map(Integer::parseInt)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) {
                        if (i % 2 == 0 && i > 2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());
        System.out.println(ListParesMaioresQue2);*/
        List<Integer> ListParesMaioresQue2 = numeros.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2))
                .collect(Collectors.toList());
        System.out.println(ListParesMaioresQue2);

        System.out.println("Mostrar a média dos números");
        /*numeros.stream()
                .mapToInt(new ToIntFunction<String>() {
                    @Override
                    public int applyAsInt(String s) {
                        return Integer.parseInt(s);
                    }
                });*/
       /* numeros.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(new DoubleConsumer() {
                    @Override
                    public void accept(double v) {
                        System.out.println(v);
                    }
                });
        ;*/
        numeros.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os numeros impares: ");
        numerosInt.removeIf(integer -> integer % 2 != 0);
        System.out.println(numerosInt);

        System.out.println("\nIgnore os 3 primeiros elementos da lista e imprima o restante");
        List<Integer> ListParesMaioresQue3 = numeros.stream()
                .map(Integer::parseInt)
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(ListParesMaioresQue3);

        System.out.println("\n Retirando os números repetidos da lista, quantos números ficam?");
        Set<Integer> setSemRepetir = numeros.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        System.out.println(setSemRepetir.size());

        //como a prof fez:
        long countNumerosUnicos = numeros.stream()
                .distinct()
                .count();
        System.out.println("Prof fez : Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);

        System.out.println("\n Mostre o menor valor da lista: ");
        setSemRepetir
                .stream()
                .mapToInt((Integer intValue) -> intValue)
                .min()
                .ifPresent(System.out::println);
        System.out.println("\n Mostre o maior valor da lista: ");
        setSemRepetir
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);
        System.out.println("\n Pegue apenas os números impares e some: ");
        List<Integer> listImpar = numeros.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int soma = listImpar.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        if (integer % 2 != 0) return true;
                        return false;
                    }
                })
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(soma);

        System.out.println("\n Mostre a lista na ordem númerica: ");
        List<Integer> ordemNumericaLista = numeros.stream()
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(ordemNumericaLista);

        System.out.println("\n Agrupe os valores ímpares múltiplos de 3 e de 5");
        //dica : collect(collectors.groupingBy(new Function()):
        Map<Boolean, List<Integer>> numerosMultiplos3E5 = ordemNumericaLista.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(numerosMultiplos3E5);

    }
}

/*
[x] Crie um conjunto contendo as cores do arco-íris e

[X]Exiba todas as cores uma abaixo da outra

[x]A quantidade de cores que o arco-íris tem

[x]Exiba as cores em ordem alfabética

[x]Exiba as cores na ordem inversa da que foi informada

[x]Exiba todas as cores que começam com a letra ”v”

[x]Remova todas as cores que não começam com a letra “v”

[x]Limpe o conjunto

[x]Confira se o conjunto está vazio
 */
package com.mycompany.exercicios.dio.collections.Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author wesle
 */
public class ArcoÍris {

    public static void main(String args[]) {
        //Crie um conjunto contendo as cores do arco-íris e:
        Set<String> cores = new HashSet<>();
        cores.add("Vermelho");
        cores.add("Laranja");
        cores.add("Vermelho");
        cores.add("Amarelo");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Anil");
        cores.add("Violeta");
        
        System.out.println("Exiba todas as cores uma abaixo da outra");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println("\nA quantidade de cores que o arco-íris tem : " + cores.size());

        System.out.println("\nExiba as cores em ordem alfabética");
        Set<String> coresTree = new TreeSet<>(cores);
        System.out.println(coresTree);

        System.out.println("\nExiba as cores na ordem inversa da que foi informada");
        Set<String> coresLinkedHashSet = new LinkedHashSet<>(cores);
        System.out.println(coresLinkedHashSet);
        List<String> inverteCores = new ArrayList<>(coresLinkedHashSet);
        Collections.reverse(inverteCores);
        System.out.println(inverteCores);

        System.out.println("\nExiba todas as cores que começam com a letra ”v”");
        for (String cor : cores) {
            if (cor.startsWith("V")) {
                System.out.println(cor);
            }
        }
        System.out.println("\nRemova todas as cores que não começam com a letra “v”");
        Iterator<String> coresRemove = cores.iterator();
        while (coresRemove.hasNext()) {
            String next = coresRemove.next();
            if (next.startsWith("V")) {
                coresRemove.remove();
            }
        }

        System.out.println(cores);

        System.out.println("\nLimpe o conjunto");
        cores.clear();
        System.out.println(cores);

        System.out.println("\nConfira se o conjunto está vazio : " + cores.isEmpty());

    }
}

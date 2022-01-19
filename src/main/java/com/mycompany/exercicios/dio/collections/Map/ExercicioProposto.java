/*


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
public class ExercicioProposto {

    public static void main(String[] args) {
        System.out.println("Crie um dicionário e relacione os estados e suas populações;");
        Map<String, Integer> estados = new HashMap<>() {
            {
                put("PE", 9616621);
                put("AL", 3351543);
                put("CE", 9187103);
                put("RN", 3534265);
            }
        };
        System.out.println(estados);

        System.out.println("\n Substitua a população do estado do RN por 3.534.165");
        estados.put("RN", 3534165);
        System.out.println(estados);

        System.out.println("\n Confira se o estado PB está no dicionário: " + estados.containsKey("PB") + "|\t caso não adicione: PB 4.039.277");
        boolean containsKey = estados.containsKey("PB");

        if (containsKey == false) {
            estados.put("PB", 4039277);
        }
        System.out.println(estados);

        System.out.println("\nExiba a população PE " + estados.get("PE"));

        System.out.println("\nExiba todos os estados e suas populações na ordem que foi informado ");
        Map<String, Integer> estados1 = new LinkedHashMap<>() {
            {
                put("PE", 9616621);
                put("AL", 3351543);
                put("CE", 9187103);
                put("RN", 3534265);
            }
        };
        System.out.println(estados1);

        System.out.println("\nExiba os estados e suas populações em ordem alfabética");
        Map<String, Integer> estados2 = new TreeMap<>() {
            {
                put("PE", 9616621);
                put("AL", 3351543);
                put("CE", 9187103);
                put("RN", 3534265);
            }
        };
        System.out.println(estados2);

        System.out.println("\nExiba o estado com o menor população e sua quantidade;");
        Integer qtdMenorPopulacao = Collections.min(estados.values());
        Set<Map.Entry<String, Integer>> entrySet = estados.entrySet();
        String nomeMenorPopulacao;
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() == qtdMenorPopulacao) {
                nomeMenorPopulacao = entry.getKey();
                System.out.println(nomeMenorPopulacao + " com apenas : " + qtdMenorPopulacao);
            }
        }

        System.out.println("\nExiba o estado com o maior população e sua quantidade;");
        Integer qtdMaiorPopulacao = Collections.max(estados.values());
        Set<Map.Entry<String, Integer>> entrySet1 = estados.entrySet();
        String nomeMaiorPopulacao;
        for (Map.Entry<String, Integer> entry : entrySet1) {
            if (entry.getValue() == qtdMaiorPopulacao) {
                nomeMaiorPopulacao = entry.getKey();
                System.out.println(nomeMaiorPopulacao + " com : " + qtdMaiorPopulacao);
            }
        }

        System.out.println("\nExiba a soma da população desses estados");
        Integer soma = 0;
        Iterator<Integer> iterator = estados.values().iterator();
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println("\nExiba a média da população deste dicionário de estados: " + (soma / estados.size()));

        System.out.println("\nRemova os estados com a população menor que 4.000.000");
        Iterator<Integer> iterator1 = estados.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() < 4000000) {
                iterator1.remove();
            }
        }
        System.out.println(estados);
        
        System.out.println("\nApague o dicionário de estados");
        estados.clear();
        System.out.println(estados);
        System.out.println("\nConfira se o dicionário está vazio: " + estados.isEmpty());
    }
}

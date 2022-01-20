/*
Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);
id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
 */
package com.mycompany.exercicios.dio.collections.Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author wesle
 */
public class ExercicioProposto3 {

    public static void main(String[] args) {
        Map<Integer, Contato> agenda = new HashMap<>() {
            {
                put(1, new Contato("Simba", 2222));
                put(4, new Contato("Cami", 5555));
                put(3, new Contato("Jon", 1111));
                put(6, new Contato("Maria", 9876));
                put(10, new Contato("Leon", 1234));
                put(31, new Contato("Morgana", 7777));
            }
        };
        System.out.println(agenda);
        System.out.println("\nOrdem de inserção");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>() {
            {
                put(1, new Contato("Simba", 2222));
                put(4, new Contato("Cami", 5555));
                put(3, new Contato("Jon", 1111));
            }
        };
        System.out.println(agenda1);

        System.out.println("\nOrdem ID");
        Map<Integer, Contato> agenda3 = new TreeMap<>(agenda);
        for (Map.Entry<Integer, Contato> entry : agenda3.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue().getNome());
        }
        System.out.println("\nOrdem número telefone");
        Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(new ComparatorTelefone());
        agenda4.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry1 : agenda4) {
            System.out.println(entry1.getKey() + " - " + entry1.getValue().getNumero() + " : " + entry1.getValue().getNome());
        }
        
        System.out.println("\n Ordem nome Contato");
        Set<Map.Entry<Integer, Contato>> agenda5 = new TreeSet<>(new ComparatorNome());
        agenda5.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : agenda5) {
            System.out.println(entry.getKey()+ " - " + entry.getValue().getNome());
            
        }
        
    }
}

class Contato {

    private String nome;
    private Integer numero;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contato{" + "nome=" + nome + ", numero=" + numero + '}';
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }
}

class ComparatorTelefone implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
    }

}

class ComparatorNome implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }

}

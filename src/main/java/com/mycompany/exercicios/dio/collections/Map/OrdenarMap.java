/*Dadas as seguintes informações sobre meus livros favoritos e seus autores,
crie um dicionário e ordene este dicionário:
exibindo (Nome Autor - Nome Livro);
Autor = Hawking, Stephen  - Livro = nome: Uma Breve História do Tempo. páginas: 256
Autor = Duhigg, Charles - Livro = nome: O Poder do Hábito, paginas: 408
Autor = Harari, Yuval Noah  - Livro = 21 Lições Para o Século 21, páginas: 432
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
public class OrdenarMap {

    public static void main(String[] args) {
        System.out.println("\n Ordem aleatoória");
        Map<String, Livro> meusLivros = new HashMap<>() {
            {
                put("Hawking Stephen", new Livro("Uma Breve História do Tempo", 256));
                put("Duhigg Charles", new Livro("O Poder do Hábito", 408));
                put("Harari Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
            }
        };
        Set<Map.Entry<String, Livro>> entrySet = meusLivros.entrySet();
        for (Map.Entry<String, Livro> entry : entrySet) {
            System.out.println(entry.getKey() + " | " + entry.getValue().getNome());
        }

        System.out.println("\n Ordem de inserção");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>() {
            {
                put("Hawking Stephen", new Livro("Uma Breve História do Tempo", 256));
                put("Duhigg Charles", new Livro("O Poder do Hábito", 408));
                put("Harari Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
            }
        };
        System.out.println(meusLivros1);

        System.out.println("\n Ordem alfabética autores");
        Map<String, Livro> meusLivros2 = new TreeMap<>() {
            {
                put("Hawking Stephen", new Livro("Uma Breve História do Tempo", 256));
                put("Duhig Charles", new Livro("O Poder do Hábito", 408));
                put("Harar Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
            }
        };
        System.out.println(meusLivros2);

        System.out.println("\n Ordem alfabética nomes dos livros");
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNomeLivro());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> entry1 : meusLivros3) {
            System.out.println(entry1.getKey() + " | " + entry1.getValue().getNome());
        }
        System.out.println("\n Ordenar número de página");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPaginas());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> entry2 : meusLivros4) {
            System.out.println(entry2.getKey() + " | " + entry2.getValue().getPaginas());
        }
    }

}

class Livro {

    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.nome);
        hash = 19 * hash + Objects.hashCode(this.paginas);
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
        final Livro other = (Livro) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Livro{" + "nome=" + nome + ", paginas=" + paginas + '}';
    }

}

class ComparatorNomeLivro implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }

}

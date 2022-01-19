/*
 * 
Crie uma classe LinguagemFavorita que possua os atributos
nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
3 linguagens e faça um programa que ordene esse conjunto
por:

-Ordem de Inserção

Ordem Natural (nome)

IDE

Ano de criação e nome

Nome, ano de criacao e IDE

Ao final, exiba as linguagens no console, um abaixo da outra.
 */
package com.mycompany.exercicios.dio.collections.Set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author wesle
 */
public class Exercicio2 {

    public static void main(String args[]) {
        Set<LinguagemFavorita> lFavorita = new HashSet<>();
        LinguagemFavorita favorita1 = new LinguagemFavorita();
        favorita1.setNome("Java");
        favorita1.setAnoDeCriacao(1991);
        favorita1.setIde("Netbeans");
        lFavorita.add(favorita1);
        LinguagemFavorita favorita2 = new LinguagemFavorita();
        favorita2.setNome("C#");
        favorita2.setAnoDeCriacao(2000);
        favorita2.setIde("Visual Studio");
        lFavorita.add(favorita2);
        LinguagemFavorita favorita3 = new LinguagemFavorita();
        favorita3.setNome("JavaScript");
        favorita3.setAnoDeCriacao(1995);
        favorita3.setIde("Eclipse");
        lFavorita.add(favorita3);

        System.out.println("Ordem de Inserção");
        Set<LinguagemFavorita> lFavorita1 = new LinkedHashSet<>(lFavorita);
        System.out.println(lFavorita1);

        System.out.println("Ordem Natural (nome)");
        Set<LinguagemFavorita> lFavorita2 = new TreeSet<LinguagemFavorita>(new ComparatorNome());
        lFavorita2.addAll(lFavorita);
        for (LinguagemFavorita linguagemFavorita : lFavorita2) {
            System.out.println(linguagemFavorita);
        }

        System.out.println("Ordem Natural (IDE)");
        Set<LinguagemFavorita> lFavorita3 = new TreeSet<>(new ComparatorIde());
        lFavorita3.addAll(lFavorita);
        for (LinguagemFavorita linguagemFavorita : lFavorita3) {
            System.out.println(linguagemFavorita);
        }
        System.out.println("Ano de criação e nome");
        Set<LinguagemFavorita> lFavorita4 = new TreeSet<>(new ComparatorAnoCriacaoENome());
        lFavorita4.addAll(lFavorita);
        for (LinguagemFavorita linguagemFavorita : lFavorita4) {
            System.out.println(linguagemFavorita);

        }
        Set<LinguagemFavorita> HFavoritaTeste = new HashSet<>();
        LinguagemFavorita lFavoritaTeste1 = new LinguagemFavorita();
        lFavoritaTeste1.setNome("A");
        lFavoritaTeste1.setAnoDeCriacao(2000);
        lFavoritaTeste1.setIde("A");
        HFavoritaTeste.add(lFavoritaTeste1);
        LinguagemFavorita lFavoritaTeste2 = new LinguagemFavorita();
        lFavoritaTeste2.setNome("A");
        lFavoritaTeste2.setAnoDeCriacao(2000);
        lFavoritaTeste2.setIde("B");
        HFavoritaTeste.add(lFavoritaTeste2);
        LinguagemFavorita lFavoritaTeste3 = new LinguagemFavorita();
        lFavoritaTeste3.setNome("A");
        lFavoritaTeste3.setAnoDeCriacao(2000);
        lFavoritaTeste3.setIde("C");
        HFavoritaTeste.add(lFavoritaTeste3);

        System.out.println("Nome, ano de criacao e IDE");
        Set<LinguagemFavorita> lFavorita5 = new TreeSet<>(new ComparatoNomeAnoIde());
        lFavorita5.addAll(HFavoritaTeste);
        for (LinguagemFavorita linguagemFavorita : lFavorita5) {
            System.out.println(linguagemFavorita);
        }
    }
}

class LinguagemFavorita {

    String nome;
    Integer anoDeCriacao;
    String ide;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the anoDeCriacao
     */
    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    /**
     * @return the ide
     */
    public String getIde() {
        return ide;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param anoDeCriacao the anoDeCriacao to set
     */
    public void setAnoDeCriacao(Integer anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    /**
     * @param ide the ide to set
     */
    public void setIde(String ide) {
        this.ide = ide;
    }

    @Override
    public String toString() {
        return "LinguagemFavorita {" + "nome = " + nome + ", anoDeCriacao = " + anoDeCriacao + ", ide = " + ide + '}';
    }

}

class ComparatorNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
        return lf1.nome.compareToIgnoreCase(lf2.nome);
    }
}

class ComparatorIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
        return lf1.ide.compareToIgnoreCase(lf2.ide);
    }
}

class ComparatorAnoCriacaoENome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
        int anoDeCriacao = Integer.compare(lf1.anoDeCriacao, lf2.anoDeCriacao);
        if (anoDeCriacao != 0) {
            return anoDeCriacao;
        }
        return lf1.nome.compareToIgnoreCase(lf2.nome);
    }

}

class ComparatoNomeAnoIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
        int nome = lf1.nome.compareToIgnoreCase(lf2.nome);
        int anoDeCriacao = Integer.compare(lf1.anoDeCriacao, lf2.anoDeCriacao);
        if (nome != 0) {
            return nome;
        } else if (anoDeCriacao != 0) {
            return anoDeCriacao;
        }
        return lf1.ide.compareToIgnoreCase(lf2.ide);
    }
}

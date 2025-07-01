package model;

import java.util.*;

public class Cidade implements Comparable<Cidade> {
    private String nome;
    private String estado;
    private int populacao;

    public Cidade(String nome, String estado, int populacao) {
        this.nome = nome;
        this.estado = estado;
        this.populacao = populacao;
    }

    public Cidade(String nome, int populacao) {
        this(nome, "", populacao);
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public int getPopulacao() {
        return populacao;
    }

    @Override
    public int compareTo(Cidade outra) {
        return this.nome.compareToIgnoreCase(outra.nome);
    }

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Cidade)) return false;
    Cidade cidade = (Cidade) o;
    return nome.equalsIgnoreCase(cidade.nome);
}

@Override
public int hashCode() {
    return Objects.hash(nome.toLowerCase());
}

    @Override
    public String toString() {
        return nome + (estado.isEmpty() ? "" : ", " + estado) + " (pop: " + populacao + ")";
    }
}

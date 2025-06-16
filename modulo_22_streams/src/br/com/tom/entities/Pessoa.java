package br.com.tom.entities;

import br.com.tom.enumerators.Genero;

import java.util.List;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private String nacionalidade;
    private Genero genero;

    public Pessoa() {
    }

    public Pessoa(String nome, String nacionalidade, Genero genero) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.genero = genero;
    }

    public List<Pessoa> popularDados(){
        Pessoa pessoa1 = new Pessoa("Ana Silva", "Brasileira", Genero.FEMININO);
        Pessoa pessoa2 = new Pessoa("João Santos", "Brasileiro", Genero.MASCULINO);
        Pessoa pessoa3 = new Pessoa("Maria Oliveira", "Portuguesa", Genero.FEMININO);
        Pessoa pessoa4 = new Pessoa("Pedro Almeida", "Argentino", Genero.MASCULINO);
        Pessoa pessoa5 = new Pessoa("Lucas Ferreira", "Chileno", Genero.MASCULINO);
        Pessoa pessoa6 = new Pessoa("Sofia Costa", "Espanhola", Genero.FEMININO);
        Pessoa pessoa7 = new Pessoa("Alexandra Souza", "Brasileiro", Genero.FEMININO);
        Pessoa pessoa8 = new Pessoa("Clara Mendes", "Mexicana", Genero.FEMININO);
        Pessoa pessoa9 = new Pessoa("Rafael Lima", "Colombiano", Genero.MASCULINO);
        Pessoa pessoa10 = new Pessoa("Júlia Pereira", "Brasileira", Genero.FEMININO);
        return List.of(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5, pessoa6, pessoa7, pessoa8, pessoa9, pessoa10);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", genero=" + genero +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getNacionalidade(), pessoa.getNacionalidade()) && genero == pessoa.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getNacionalidade(), genero);
    }
}

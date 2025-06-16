import java.util.Arrays;

public class Livro {
    private String nome;
    private Integer numero_paginas;
    private String genero;
    private String[] autores;
    private String editora;

    public Livro(String nome, Integer numero_paginas, String genero, String[] autores, String editora) {
        this.nome = nome;
        this.numero_paginas = numero_paginas;
        this.genero = genero;
        this.autores = autores;
        this.editora = editora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero_paginas() {
        return numero_paginas;
    }

    public void setNumero_paginas(Integer numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append(", ");
        sb.append("Número de páginas: ").append(numero_paginas).append(", ");
        sb.append("Gênero: ").append(genero).append(", ");
        sb.append("Lista de Autores: ").append(Arrays.toString(autores)).append(", ");
        sb.append("Editora: ").append(editora);
        return sb.toString();
    }

}

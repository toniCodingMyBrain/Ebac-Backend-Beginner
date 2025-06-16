public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private Genero sexo;
    private Integer idade;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, Genero sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Genero getSexo() {
        return sexo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.sexo == null || this.idade == null) {
            sb.append("Nome: " + this.nome + ";");
            return sb.toString();
        } else {
            sb.append("Nome: "
                    + this.nome + ", idade: "
                    + this.idade
                    + ", gênero: "
                    + this.sexo + ";");
            return sb.toString();
        }
    }

    @Override
    public int compareTo(Pessoa p) {
        return this.nome.compareTo(p.getNome().toLowerCase());
    }
}

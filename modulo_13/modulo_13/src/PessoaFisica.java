import java.util.Arrays;

public class PessoaFisica extends Pessoa {
    private int[] CPF = new int[11];

    public PessoaFisica() {
    }

    public int[] getCPF() {
        return CPF;
    }

    public void setCPF(int[] CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        String cpfNumeros = Arrays.toString(this.CPF).replaceAll("[\\[\\], ]", "");
        String cpfFormatado = cpfNumeros.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        return "Pessoa Física\n\t\t"
                + "Nome: " + this.getNome() + ",\n\t\t"
                + "Idade: " + this.getIdade() + ",\n\t\t"
                + "CPF: "
                + cpfFormatado
                + ";";
    }
}

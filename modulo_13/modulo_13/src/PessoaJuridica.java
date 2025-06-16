import java.util.Arrays;

public class PessoaJuridica extends Pessoa {
    private int[] CNPJ = new int[14];

    public PessoaJuridica() {
    }

    public int[] getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int[] CNPJ) {
        this.CNPJ = CNPJ;
    }

    @Override
    public String toString() {
        String CNPJNumeros = Arrays.toString(this.CNPJ).replaceAll("[\\[\\], ]", "");
        String CNPJFormatado = CNPJNumeros.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        return "Pessoa Jurídica\n\t\t"
                + "Nome: " + this.getNome() + ",\n\t\t"
                + "Idade: " + this.getIdade() + ",\n\t\t"
                + "CNPJ: "
                + CNPJFormatado
                + ";";
    }
}

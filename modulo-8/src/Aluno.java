import java.util.ArrayList;
import java.util.List;

public class Aluno {
    String nome_aluno;
    List<Double> notas = new ArrayList<>();

    public void adicionarNotas(double nota) {
        notas.add(nota);
    }

    public double calcularMedia() {
        double soma = 0;
        for (Double nota : notas) {
            soma += nota;
        }
        return soma / 4;
    }

    @Override
    public String toString() {
        return "\nO aluno " + nome_aluno + ", obteve as notas " + notas + ".\n";
    }

}


public class App {
    public static void main(String[] args) throws Exception {
        Aluno aluno = new Aluno();
        aluno.nome_aluno = "Dominic Young";
        aluno.adicionarNotas(9.8D);
        aluno.adicionarNotas(6.7D);
        aluno.adicionarNotas(7.9D);
        aluno.adicionarNotas(8.8D);
        double media = aluno.calcularMedia();

        System.out.println(aluno + "E obtendo a média: " + media + ".");

        System.out.println("End program!");
    }
}

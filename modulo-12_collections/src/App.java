import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        System.out.print(
                "\nAdicionar lista de: [1] Nome apenas. [2] Informações de pessoa.\nDigite o número da escolha:");
        int operacao = scan.nextInt();
        if (operacao == 1) {
            // Método de adicionar apenas nome das pessoas.
            System.out.print("Digite quantas pessoas serão adicionadas: ");
            int qtdPessoas = scan.nextInt();
            ListaPessoas listaPessoasporNome = new ListaPessoas();
            scan.nextLine();
            for (int i = 0; i < qtdPessoas; i++) {
                System.out.print("Digite apenas o nome da pessoa: ");
                String nomePessoa = scan.nextLine();
                Pessoa novaPessoa = new Pessoa(nomePessoa);
                listaPessoasporNome.adicionarNomePessoa(novaPessoa);
            }
            // Collections.sort(listaPessoasporNome);
            System.out.println("Lista de nomes: ");
            System.out.println(listaPessoasporNome);

        } else if (operacao == 2) {
            // Método de adicionar pessoas com idade e gênero.
            ListaPessoas listaPessoasporInformacoes = new ListaPessoas();
            System.out.print("Digite quantas pessoas serão adicionadas: ");
            int qtdPessoas = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < qtdPessoas; i++) {
                System.out.print(
                        "Digite o nome da pessoa, gênero e idade, nesta ordem, usando uma vírgula sem espaços: ");
                String infoNovaPessoa = scan.nextLine();
                String[] pessoaCompleta = infoNovaPessoa.split(",");
                String nomePessoa = pessoaCompleta[0];
                Genero generoPessoa = Genero.valueOf(pessoaCompleta[1].toUpperCase());
                int idadePessoa = Integer.parseInt(pessoaCompleta[2]);
                Pessoa novaPessoa = new Pessoa(nomePessoa, generoPessoa, idadePessoa);
                listaPessoasporInformacoes.adicionarPessoa(novaPessoa);
            }
            System.out.println(listaPessoasporInformacoes.toString());
        }

        scan.close();
    }
}

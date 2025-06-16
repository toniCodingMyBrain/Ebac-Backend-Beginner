import java.util.*;

public class ListaPessoas {
    private List<Pessoa> pessoa = new ArrayList<>();

    public ListaPessoas() {
    }

    public List<Pessoa> getPessoa() {
        return pessoa;
    }

    public void adicionarPessoa(Pessoa pessoa) {
        this.pessoa.add(pessoa);
    }

    public void adicionarNomePessoa(Pessoa novaPessoa) {
        this.pessoa.add(novaPessoa);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(pessoa);
        sb.append("Lista de pessoas: \n");
        for (int i = 0; i < pessoa.size(); i++) {
            sb.append("\t" + (i + 1) + "ª pessoa: \n\t" + pessoa.get(i) + "\n");
        }
        return sb.toString();
    }

}

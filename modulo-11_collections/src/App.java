import java.util.ArrayList;
import java.util.List;

public class App {
    /*
     * private static String nome;
     * private static String[] masculino;
     * private static String[] feminino;
     * 
     * public static String[] getGenreMasc(List<String[]> pessoasList) {
     * for (int i = 0; i < pessoasList.size(); i++) {
     * if (pessoasList.get(i)[1].equalsIgnoreCase(String.valueOf(Genero.MAS))) {
     * nome = pessoasList.get(i)[0];
     * masculino[i] = nome;
     * }
     * }
     * return masculino;
     * }
     */

    public static void main(String[] args) throws Exception {
        List<String[]> pessoas = new ArrayList<String[]>();

        pessoas.add(new String[] { "Emma Mendoza", String.valueOf(Genero.FEM) });
        pessoas.add(new String[] { "Lester White", String.valueOf(Genero.MAS) });
        pessoas.add(new String[] { "Eddie Hernandez", String.valueOf(Genero.MAS) });
        pessoas.add(new String[] { "Roger Dunn", String.valueOf(Genero.MAS) });
        pessoas.add(new String[] { "Mollie Montgomery", String.valueOf(Genero.FEM) });
        pessoas.add(new String[] { "Nora Bowman", String.valueOf(Genero.FEM) });
        System.out.println();
        System.out.println("Classificação: ");
        System.out.println("\nLista de homens: ");
        for (int h = 0; h < pessoas.size(); h++) {
            if (pessoas.get(h)[1].equalsIgnoreCase(String.valueOf(Genero.MAS)))
                System.out.println("Nome: " + pessoas.get(h)[0] + ".");
        }

        System.out.println("\nLista de mulheres: ");
        for (int m = 0; m < pessoas.size(); m++) {
            if (pessoas.get(m)[1].equalsIgnoreCase(String.valueOf(Genero.FEM)))
                System.out.println("Nome: " + pessoas.get(m)[0] + ".");
        }

        System.out.println("\nEnd program...");
    }

}

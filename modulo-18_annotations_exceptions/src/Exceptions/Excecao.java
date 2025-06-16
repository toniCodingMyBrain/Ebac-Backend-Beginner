package Exceptions;

import java.util.Locale;
import java.util.Scanner;

public class Excecao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Locale.setDefault(Locale.ENGLISH);
        int[] vetor = new int[4];
        System.out.println("");
        System.out.print("Digite o índice que deseja adicionar o valor: ");
        int index = scan.nextInt();
        try {
            vetor[index] = 1;// Aqui vai ser lançada a Exception ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exceção: " + e.getMessage() + ".");
            System.out.println("Não foi possível encontrar elemento no vetor.");
        } finally {
            System.out.println("Este foi o programa, obrigado pela preferência.");
        }

        scan.close();
    }
}

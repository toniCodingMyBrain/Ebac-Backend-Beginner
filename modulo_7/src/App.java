
public class App {
    public static void main(String[] args) throws Exception {
        String[] autores_deste_livro = { "J. R. R. Tolkien" };

        Livro livro_LOTR = new Livro("The Lord Of The Rings", 1000, "Medieval Fictício",
                autores_deste_livro, "Harper Collins");
        System.out.println("Olá, esta é sua livraria, seu livro de hoje é: " + livro_LOTR);
    }
}

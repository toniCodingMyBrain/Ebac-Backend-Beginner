public class App {
    public static void main(String[] args) throws Exception {
        PessoaFisica pessoaFisica1 = new PessoaFisica();
        pessoaFisica1.setNome("Marcus Sanders");
        pessoaFisica1.setIdade(20);
        pessoaFisica1.setCPF(new int[] { 1, 4, 2, 5, 6, 0, 2, 5, 1, 6, 9 });

        PessoaFisica pessoaFisica2 = new PessoaFisica();
        pessoaFisica2.setNome("Jeffery Barnes");
        pessoaFisica2.setIdade(31);
        pessoaFisica2.setCPF(new int[] { 6, 7, 5, 3, 8, 1, 8, 0, 7, 1, 4 });

        System.out.println("\n\nPessoas:");
        System.out.println("\t" + pessoaFisica2.toString());
        System.out.println("\t" + pessoaFisica1.toString());

        PessoaJuridica pessoaJuridica1 = new PessoaJuridica();
        pessoaJuridica1.setNome("Elmer Bowman");
        pessoaJuridica1.setIdade(29);
        pessoaJuridica1.setCNPJ(new int[] { 3, 7, 5, 0, 4, 3, 5, 8, 1, 0, 0, 7, 0, 4 });

        PessoaJuridica pessoaJuridica2 = new PessoaJuridica();
        pessoaJuridica2.setNome("Jeffrey Bailey");
        pessoaJuridica2.setIdade(40);
        pessoaJuridica2.setCNPJ(new int[] { 6, 5, 1, 4, 7, 1, 6, 5, 9, 0, 7, 5, 4, 6 });

        System.out.println("\t" + pessoaJuridica1.toString());
        System.out.println("\t" + pessoaJuridica2.toString());
    }
}

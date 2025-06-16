package Annotation;

@Tabela(nomeCompleto = { "Gussie", "Figueroa" }, cidade = "Rio de Janeiro")
public class TabelaTeste {
    private String[] nomeCompleto;
    private String cidade;

    @Tabela(nomeCompleto = { "Aaron", "Williams" }, cidade = "São Paulo")
    public TabelaTeste() {
    }
}

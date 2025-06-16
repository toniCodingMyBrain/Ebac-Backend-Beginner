package Annotations;

@Tabela(nomeCompleto = {}, cidade = "")
public class TabelaTeste {
    private String[] nomeCompleto;
    private String cidade;

    @Tabela(nomeCompleto = { "Aaron", "Williams" }, cidade = "São Paulo")
    public TabelaTeste() {
    }
}

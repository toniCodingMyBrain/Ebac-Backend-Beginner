public enum Genero {
    MAS("Masculino"),
    FEM("Feminino");

    public String genero;

    private Genero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
}
public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    RETARDADOS("Retardados");

    private String genero;

    Genero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

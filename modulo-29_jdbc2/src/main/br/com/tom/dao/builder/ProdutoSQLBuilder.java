package main.br.com.tom.dao.builder;

public class ProdutoSQLBuilder {
    public static String getInsertSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO tb_produto (nome, codigo)");
        sb.append("VALUES (?, ?)");
        return sb.toString();
    }

    public static String getUpdateSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE tb_produto SET nome = ?, codigo = ? WHERE codigo = ?");
        return sb.toString();
    }

    public static String getDeleteSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM tb_produto WHERE codigo = ?");
        return sb.toString();
    }

    public static String getSelectAllSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM tb_produto");
        return sb.toString();
    }

    public static String getSelectByCodSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM tb_produto WHERE codigo = ?");
        return sb.toString();
    }
}
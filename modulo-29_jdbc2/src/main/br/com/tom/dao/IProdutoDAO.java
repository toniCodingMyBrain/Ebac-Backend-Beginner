package main.br.com.tom.dao;

import main.br.com.tom.domain.Produto;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoDAO {
    Integer adicionarProduto(Produto var1) throws SQLException;

    Integer removerProduto(String var1) throws SQLException;

    Integer atualizarProduto(String var1, Produto var2) throws SQLException;

    Produto buscarProdutoPorId(String var1) throws SQLException;

    List<Produto> buscarTodosProdutos() throws SQLException;
}
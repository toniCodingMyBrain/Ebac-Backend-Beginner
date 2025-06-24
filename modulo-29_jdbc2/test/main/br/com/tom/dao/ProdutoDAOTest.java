package main.br.com.tom.dao;

import main.br.com.tom.domain.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ProdutoDAOTest {
    @Test
    public void adicionarProdutoTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setNome("Produto Teste");
        produto.setCodigo("101030");
        Integer qtde = dao.adicionarProduto(produto);
        Assert.assertTrue(qtde == 1);
        String codigo = "101030";
        Integer produtoRemovido = dao.removerProduto(codigo);
        Assert.assertTrue(produtoRemovido == 1);
    }

    @Test
    public void removerProdutoTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setNome("Produto Teste");
        produto.setCodigo("101030");
        Integer qtde = dao.adicionarProduto(produto);
        Assert.assertTrue(qtde == 1);
        String codigo = "101030";
        Integer produtoRemovido = dao.removerProduto(codigo);
        Assert.assertTrue(produtoRemovido == 1);
    }

    @Test
    public void atualizarProdutoTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setNome("Produto Teste");
        produto.setCodigo("101030");
        Integer qtde = dao.adicionarProduto(produto);
        Assert.assertTrue(qtde == 1);
        String codigo = "101030";
        Produto produtoTeste = new Produto();
        produtoTeste.setNome("Produto de Teste 001");
        Integer produtoAtualizado = dao.atualizarProduto(codigo, produtoTeste);
        Assert.assertTrue(produtoAtualizado == 1);
        Integer produtoRemovido = dao.removerProduto(codigo);
        Assert.assertTrue(produtoRemovido == 1);
    }

    @Test
    public void buscarProdutoPorIdTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();
        String codigo = "102010";
        Produto produtoEncontrado = dao.buscarProdutoPorId(codigo);
        Assert.assertNotNull(produtoEncontrado);
        Assert.assertEquals("Produto 2", produtoEncontrado.getNome());
    }

    @Test
    public void buscarTodosProdutosTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.buscarTodosProdutos();
        Assert.assertTrue(!produtos.isEmpty());
        Assert.assertNotNull(produtos);
    }
}
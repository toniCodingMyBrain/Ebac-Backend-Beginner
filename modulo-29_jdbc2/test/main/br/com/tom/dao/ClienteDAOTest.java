package main.br.com.tom.dao;

import main.br.com.tom.domain.Cliente;
import main.br.com.tom.dao.ClienteDAO;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ClienteDAOTest {
    @Test
    public void cadastrarTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("101020");
        cliente.setNome("Antonio Da Silva");
        Integer qtde = dao.cadastrar(cliente);
        Assert.assertTrue(qtde == 1);
        Cliente clienteCadastrado = dao.buscarPorCodigo(cliente.getCodigo());
        Assert.assertNotNull(clienteCadastrado);
        Assert.assertNotNull(clienteCadastrado.getId());
        Assert.assertEquals(cliente.getCodigo(), clienteCadastrado.getCodigo());
        Assert.assertEquals(cliente.getNome(), clienteCadastrado.getNome());
        Integer dadoExcluido = dao.excluir(clienteCadastrado.getCodigo());
        Assert.assertTrue(dadoExcluido >= 1);
    }

    @Test
    public void atualizarNomeTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setNome("Antonio");
        cliente.setCodigo("102030");
        Integer qtde = dao.cadastrar(cliente);
        Assert.assertTrue(qtde == 1);
        Cliente clienteCadastrado = dao.buscarPorCodigo(cliente.getCodigo());
        Assert.assertNotNull(clienteCadastrado);
        Assert.assertEquals(cliente.getNome(), "Antonio");
        Assert.assertEquals(clienteCadastrado.getNome(), "Antonio");
        String novoNome = "Antonio Da Silva";
        Integer clienteAtualizado = dao.atualizarNome(clienteCadastrado.getCodigo(), novoNome);
        Assert.assertTrue(clienteAtualizado >= 1);
    }

    @Test
    public void atualizarCodigoTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setNome("Antonio");
        cliente.setCodigo("102030");
        Integer qtde = dao.cadastrar(cliente);
        Assert.assertTrue(qtde == 1);
        Cliente clienteCadastrado = dao.buscarPorCodigo(cliente.getCodigo());
        Assert.assertNotNull(clienteCadastrado);
        Assert.assertEquals(cliente.getCodigo(), "102030");
        Assert.assertEquals(clienteCadastrado.getCodigo(), "102030");
        String novoCodigo = "103030";
        Integer clienteAtualizado = dao.atualizarCodigo(clienteCadastrado.getCodigo(), novoCodigo);
        Assert.assertTrue(clienteAtualizado >= 1);
    }

    @Test
    public void buscarTodos() throws SQLException {
        IClienteDAO dao = new ClienteDAO();
        List<Cliente> clienteList = dao.buscarTodos(10);
        Integer qtde = clienteList.size();
        Assert.assertNotNull(clienteList);
        Assert.assertTrue(qtde >= 1);
        Assert.assertTrue(qtde <= 10);
    }

    @Test
    public void excluirTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setNome("Testinssom");
        cliente.setCodigo("102030");
        Integer qtde = dao.cadastrar(cliente);
        Assert.assertTrue(qtde == 1);
        Integer dadoExcluido = dao.excluir(cliente.getCodigo());
        Assert.assertTrue(dadoExcluido >= 1);
    }
}
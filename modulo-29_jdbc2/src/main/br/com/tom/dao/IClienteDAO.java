package main.br.com.tom.dao;

import main.br.com.tom.domain.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface IClienteDAO {
    Integer cadastrar(Cliente var1) throws SQLException;

    Cliente buscarPorCodigo(String var1) throws SQLException;

    List<Cliente> buscarTodos(Integer var1) throws SQLException;

    Integer atualizarNome(String var1, String var2) throws SQLException;

    Integer atualizarCodigo(String var1, String var2) throws SQLException;

    Integer excluir(String var1) throws SQLException;
}
package main.br.com.tom.dao;

import main.br.com.tom.dao.jdbc.ConnectionFactory;
import main.br.com.tom.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {
    public Integer cadastrar(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement pStatement = null;

        Integer var5;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO tb_cliente (NOME, CODIGO)VALUES (?, ?)";
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, cliente.getNome());
            pStatement.setString(2, cliente.getCodigo());
            var5 = pStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (pStatement != null && !pStatement.isClosed()) {
                connection.close();
            }

        }

        return var5;
    }

    public Cliente buscarPorCodigo(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet queryResult = null;
        Cliente cliente = null;

        Cliente var7;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM tb_cliente WHERE CODIGO = ?";
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, codigo);
            queryResult = pStatement.executeQuery();
            if (queryResult.next()) {
                cliente = new Cliente();
                cliente.setId((long)queryResult.getInt("ID"));
                cliente.setNome(queryResult.getString("NOME"));
                cliente.setCodigo(queryResult.getString("CODIGO"));
            }

            var7 = cliente;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (pStatement != null && !pStatement.isClosed()) {
                connection.close();
            }

        }

        return var7;
    }

    public List<Cliente> buscarTodos(Integer linhas) throws SQLException {
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet queryResult = null;
        Cliente cliente = null;

        Object var16;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM tb_cliente LIMIT ?";
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, linhas);
            queryResult = pStatement.executeQuery();
            List<Cliente> clienteList = new ArrayList();

            for(int i = 0; i < linhas; ++i) {
                if (queryResult.next()) {
                    cliente = new Cliente();
                    cliente.setId((long)queryResult.getInt("ID"));
                    cliente.setNome(queryResult.getString("NOME"));
                    cliente.setCodigo(queryResult.getString("CODIGO"));
                    clienteList.add(cliente);
                }
            }

            var16 = clienteList;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (pStatement != null && !pStatement.isClosed()) {
                connection.close();
            }

        }

        return (List<Cliente>)var16;
    }

    public Integer excluir(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement pStatement = null;

        Integer var6;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM tb_cliente WHERE CODIGO = ?";
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, codigo);
            Integer queryReturn = pStatement.executeUpdate();
            var6 = queryReturn;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (pStatement != null && !pStatement.isClosed()) {
                connection.close();
            }

        }

        return var6;
    }

    public Integer atualizarNome(String codigo, String novoNome) throws SQLException {
        Connection connection = null;
        PreparedStatement pStatement = null;

        Integer var7;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE tb_cliente SET NOME = ? WHERE CODIGO = ?";
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, novoNome);
            pStatement.setString(2, codigo);
            Integer queryReturn = pStatement.executeUpdate();
            var7 = queryReturn;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (pStatement != null && !pStatement.isClosed()) {
                connection.close();
            }

        }

        return var7;
    }

    public Integer atualizarCodigo(String codigoAtual, String novoCodigo) throws SQLException {
        Connection connection = null;
        PreparedStatement pStatement = null;

        Integer var7;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE tb_cliente SET CODIGO = ? WHERE CODIGO = ?";
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, novoCodigo);
            pStatement.setString(2, codigoAtual);
            Integer queryReturn = pStatement.executeUpdate();
            var7 = queryReturn;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (pStatement != null && !pStatement.isClosed()) {
                connection.close();
            }

        }

        return var7;
    }
}
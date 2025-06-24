package main.br.com.tom.dao;

import main.br.com.tom.dao.builder.ProdutoSQLBuilder;
import main.br.com.tom.dao.jdbc.ConnectionFactory;
import main.br.com.tom.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {
    public Integer adicionarProduto(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement pStatement = null;

        Integer var5;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = ProdutoSQLBuilder.getInsertSql();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, produto.getNome());
            pStatement.setString(2, produto.getCodigo());
            var5 = pStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (pStatement != null && !pStatement.isClosed()) {
                pStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }

        return var5;
    }

    public Integer removerProduto(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement pStatement = null;

        Integer var5;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = ProdutoSQLBuilder.getDeleteSql();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, codigo);
            var5 = pStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (pStatement != null && !pStatement.isClosed()) {
                pStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }

        return var5;
    }

    public Integer atualizarProduto(String codigo, Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement pStatement = null;

        Integer var6;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = ProdutoSQLBuilder.getUpdateSql();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, produto.getNome());
            pStatement.setString(2, codigo);
            pStatement.setString(3, codigo);
            var6 = pStatement.executeUpdate();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } finally {
            if (pStatement != null && !pStatement.isClosed()) {
                pStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }

        return var6;
    }

    public Produto buscarProdutoPorId(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement pStatement = null;
        Produto produto = new Produto();

        Produto var7;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = ProdutoSQLBuilder.getSelectByCodSql();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, codigo);
            ResultSet queryResult = pStatement.executeQuery();
            if (queryResult.next()) {
                produto.setId(queryResult.getLong("ID"));
                produto.setNome(queryResult.getString("NOME"));
                produto.setCodigo(queryResult.getString("CODIGO"));
            }

            var7 = produto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (pStatement != null && !pStatement.isClosed()) {
                pStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }

        return var7;
    }

    public List<Produto> buscarTodosProdutos() throws SQLException {
        Connection connection = null;
        PreparedStatement pStatement = null;

        Object var12;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = ProdutoSQLBuilder.getSelectAllSql();
            pStatement = connection.prepareStatement(sql);
            List<Produto> produtosList = new ArrayList();
            ResultSet queryResult = pStatement.executeQuery();
            if (queryResult.next()) {
                Produto produto = new Produto();
                produto.setId(queryResult.getLong("ID"));
                produto.setNome(queryResult.getString("NOME"));
                produto.setCodigo(queryResult.getString("CODIGO"));
                produtosList.add(produto);
            }

            var12 = produtosList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (pStatement != null && !pStatement.isClosed()) {
                pStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }

        return (List<Produto>)var12;
    }
}
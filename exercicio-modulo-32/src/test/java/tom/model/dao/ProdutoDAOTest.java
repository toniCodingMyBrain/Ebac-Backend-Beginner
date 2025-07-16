package tom.model.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tom.model.domain.Estoque;
import tom.model.domain.Fornecedor;
import tom.model.domain.Produto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoDAOTest {
    private IProduto produto;
    private IFornecedor fornecedor;
    private IEstoque estoque;

    @BeforeEach
    void SetUp() {
        produto = new ProdutoDAO();
        fornecedor = new FornecedorDAO();
        estoque = new EstoqueDAO();
    }

    @Test
    void populateDB() {
        //* Fornecedores
        List<Fornecedor> fornecedores = new ArrayList<>();

        fornecedores.add(new Fornecedor("TechWorld Importadora", "12345678000190"));
        fornecedores.add(new Fornecedor("Global Eletrônicos", "23456789000101"));
        fornecedores.add(new Fornecedor("Alpha Tech Brasil", "34567890000112"));
        fornecedores.add(new Fornecedor("Mega Componentes Ltda", "45678901000123"));
        fornecedores.add(new Fornecedor("Conecta Soluções", "56789012000134"));

        IFornecedor fornecedor = new FornecedorDAO();
        for (Fornecedor f : fornecedores) {
            fornecedor.cadastrar(f);
        }

        //* Produtos
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Mouse Gamer RGB", 129.99, fornecedores.get(1)));
        produtos.add(new Produto("Notebook Dell Inspiron i5", 3599.00, fornecedores.get(2)));
        produtos.add(new Produto("Teclado Mecânico RGB", 249.50, fornecedores.get(2)));
        produtos.add(new Produto("Roteador TP-Link AX3000", 329.99, fornecedores.get(3)));
        produtos.add(new Produto("Webcam Full HD Logitech", 379.00, fornecedores.get(3)));
        produtos.add(new Produto("SSD Kingston 1TB", 429.90, fornecedores.get(4)));
        produtos.add(new Produto("Fonte 650W 80 Plus Bronze", 299.00, fornecedores.get(4)));
        produtos.add(new Produto("Gabinete Gamer RGB", 499.00, fornecedores.get(0)));
        produtos.add(new Produto("Placa de Vídeo RTX 4060", 2399.00, fornecedores.get(0)));

        IProduto produto = new ProdutoDAO();
        for (Produto p : produtos) {
            produto.cadastrar(p);
        }

        //* Estoque
        List<Estoque> estoque = new ArrayList<>();

        estoque.add(new Estoque(produtos.get(0), 18));
        estoque.add(new Estoque(produtos.get(1), 5));
        estoque.add(new Estoque(produtos.get(2), 15));
        estoque.add(new Estoque(produtos.get(3), 12));
        estoque.add(new Estoque(produtos.get(4), 20));
        estoque.add(new Estoque(produtos.get(5), 16));
        estoque.add(new Estoque(produtos.get(6), 8));
        estoque.add(new Estoque(produtos.get(7), 9));
        estoque.add(new Estoque(produtos.get(8), 14));

        IEstoque iEstoque = new EstoqueDAO();
        for (Estoque e : estoque) {
            iEstoque.cadastrar(e);
        }

        List<Fornecedor> fornecedorList = fornecedor.buscaTodos();
        assertTrue(fornecedorList.toArray().length >= 4);

        List<Produto> produtosList = produto.buscarTodos();
        assertTrue(produtosList.toArray().length >= 5);

        List<Estoque> estoqueList = iEstoque.buscarTodos();
        assertTrue(estoqueList.toArray().length >= 5);
    }

    @Test
    void cadastrar() {
        Produto newProduto = new Produto("Notebook Acer Inspire", 2250.00, fornecedor.buscaTodos().get(0));
        produto.cadastrar(newProduto);
        Estoque novoEstoque = new Estoque(newProduto, 12);
        estoque.cadastrar(novoEstoque);

        Produto buscaProduto = produto.buscarPorId(newProduto.getId());

        assertNotNull(buscaProduto);
        assertEquals("Notebook Acer Inspire", buscaProduto.getNome());
    }

    @Test
    void buscarPorId() {
        Produto buscaProduto = produto.buscarPorId(9L);

        assertTrue(buscaProduto != null);
    }

    @Test
    void buscarTodos() {
        List<Produto> produtos = produto.buscarTodos();
        assertNotNull(produtos);
        assertTrue(produtos.size() > 1);
    }

    @Test
    void buscarPorFornecedorId() {
        List<Produto> buscaFornecedor = produto.buscarPorFornecedorId(1L);
        assertNotNull(buscaFornecedor);
    }

    @Test
    void excluir() {
        Produto newProduto = new Produto("Impressora Laser", 3000.00, fornecedor.buscaTodos().get(3));
        Estoque newEstoque = new Estoque(newProduto, 15);
        produto.cadastrar(newProduto);
        estoque.cadastrar(newEstoque);
        Estoque buscaEstoque = estoque.buscarPorId(newEstoque.getId());
        Produto buscaProduto = produto.buscarPorId(newProduto.getId());
        assertNotNull(buscaProduto);
        assertNotNull(buscaEstoque);

        produto.excluir(newProduto.getId());
        Estoque novaBuscaEstoque = estoque.buscarPorId(newEstoque.getId());
        Produto novaBuscaProduto = produto.buscarPorId(newProduto.getId());

        assertNull(novaBuscaProduto);
        assertNull(novaBuscaEstoque);

    }
}
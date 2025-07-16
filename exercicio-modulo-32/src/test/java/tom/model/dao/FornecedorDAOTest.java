package tom.model.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tom.model.domain.Estoque;
import tom.model.domain.Fornecedor;
import tom.model.domain.Produto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorDAOTest {
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
        for(Estoque e : estoque){
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
    void cadastrarEbuscarPorId() {
        //* Criando fornecedor para a associação com produto
        Fornecedor fornecedorTest = new Fornecedor("Fornecedor Teste", "12345678000195");
        fornecedor.cadastrar(fornecedorTest);

        //* criando produto
        Produto produtoTest = new Produto("Produto Teste", 99.90, fornecedorTest);
        produto.cadastrar(produtoTest);

        //* criando o estoque do produto
        Estoque estoqueProdutoTest = new Estoque(produtoTest, 10);
        estoque.cadastrar(estoqueProdutoTest);

        //* Buscar Fornecedor
        Fornecedor fornecedorBusca = fornecedor.buscarPorId(fornecedorTest.getId());

        assertNotNull(fornecedorBusca);
        assertEquals("Fornecedor Teste", fornecedorBusca.getNome());
        assertEquals(fornecedorTest.getId(), fornecedorBusca.getId());
    }

    @Test
    void atualizarPorId(){
        //* Criando fornecedor para a associação com produto
        Fornecedor fornecedorTest = new Fornecedor("Fornecedor Teste", "12345678000195");
        fornecedor.cadastrar(fornecedorTest);

        //* criando produto
        Produto produtoTest = new Produto("Produto Teste", 99.90, fornecedorTest);
        produto.cadastrar(produtoTest);

        //* criando o estoque do produto
        Estoque estoqueProdutoTest = new Estoque(produtoTest, 10);
        estoque.cadastrar(estoqueProdutoTest);

        //* Buscar Fornecedor
        Fornecedor fornecedorBusca = fornecedor.buscarPorId(fornecedorTest.getId());

        //* Testes
        assertEquals("Fornecedor Teste", fornecedorBusca.getNome());
        assertEquals(fornecedorTest.getId(), fornecedorBusca.getId());

        //* Alteração de nome de Fornecedor
        //** Criar novo Fornecedor
        Fornecedor updatedFornecedor = new Fornecedor("Fornecedor Atualizado", "99345678000195");
        fornecedor.alterar(fornecedorBusca.getId(), updatedFornecedor);

        //* Buscar Fornecedor Atualizado
        Fornecedor fornecedorBuscaAtualizado = fornecedor.buscarPorId(fornecedorTest.getId());

        assertEquals("Fornecedor Atualizado", fornecedorBuscaAtualizado.getNome());
        assertEquals(fornecedorTest.getId(), fornecedorBusca.getId());
    }

    @Test
    void buscarPorId() {
        //* Buscar Fornecedor
        Fornecedor fornecedorBusca = fornecedor.buscarPorId(2L);

        assertNotNull(fornecedorBusca);
        assertEquals("Fornecedor Teste", fornecedorBusca.getNome());
        assertEquals(2L, fornecedorBusca.getId());
    }

    @Test
    void buscaTodos() {
        List<Fornecedor> fornecedores = fornecedor.buscaTodos();
        assertNotNull(fornecedores);
    }

    @Test
    void excluir() {
        //* Buscar Fornecedor
        Fornecedor fornecedorBusca = fornecedor.buscarPorId(18L);

        assertEquals("Fornecedor Teste", fornecedorBusca.getNome());

        fornecedor.excluirPorId(fornecedorBusca.getId());

        assertNull(fornecedor.buscarPorId(18L));
    }
}
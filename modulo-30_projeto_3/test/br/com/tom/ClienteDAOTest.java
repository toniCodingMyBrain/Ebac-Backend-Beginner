package br.com.tom;

import br.com.tom.dao.ClienteDaoMock;
import br.com.tom.dao.IClienteDAO;
import br.com.tom.domain.Cliente;
import br.com.tom.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {
    private IClienteDAO clienteDao;
    private Cliente cliente;

    public ClienteDAOTest(){
        clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setNome("Tom");
        cliente.setTel(36221441L);
        cliente.setCpf(12345678911L);
        cliente.setEndereco("Rua Dos Imigrantes");
        cliente.setNumero(333);
        cliente.setCidade("Lapa");
        cliente.setEstado("PR");

        clienteDao.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean clienteSalvo = clienteDao.cadastrar(cliente);
        Assert.assertTrue(clienteSalvo);
    }

    @Test
    public void excluirCliente(){
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Antonio Luiz");
        clienteDao.alterar(cliente);
        Assert.assertEquals("Antonio Luiz", cliente.getNome());
    }
}

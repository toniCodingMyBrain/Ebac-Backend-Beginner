package br.com.tom;

import br.com.tom.dao.ClienteDaoMock;
import br.com.tom.dao.IClienteDAO;
import br.com.tom.domain.Cliente;
import br.com.tom.exceptions.TipoChaveNaoEncontradaException;
import br.com.tom.service.ClienteService;
import br.com.tom.service.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {
    private Cliente cliente;
    private IClienteService clienteService;

    public ClienteServiceTest(){
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setNome("Tom");
        cliente.setTel(36221441L);
        cliente.setCpf(12345678911L);
        cliente.setEndereco("Rua Dos Imigrantes");
        cliente.setNumero(333);
        cliente.setCidade("Lapa");
        cliente.setEstado("PR");
    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean clienteSalvo = clienteService.salvar(cliente);
        Assert.assertTrue(clienteSalvo);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Antonio Luiz");
        clienteService.alterar(cliente);
        Assert.assertEquals("Antonio Luiz", cliente.getNome());
    }
}
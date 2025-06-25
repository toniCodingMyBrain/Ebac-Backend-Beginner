package br.com.tom; /**
 * 
 */

import br.com.tom.dao.ClienteDaoMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.tom.dao.IClienteDAO;
import br.com.tom.domain.Cliente;
import br.com.tom.exceptions.DAOException;
import br.com.tom.exceptions.TipoChaveNaoEncontradaException;
import br.com.tom.services.ClienteService;
import br.com.tom.services.IClienteService;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Rodrigo Pires");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Rodrigo Pires", cliente.getNome());
	}
}
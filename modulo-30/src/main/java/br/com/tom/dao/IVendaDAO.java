/**
 * 
 */
package br.com.tom.dao;

import br.com.tom.dao.generic.IGenericDAO;
import br.com.tom.domain.Venda;
import br.com.tom.exceptions.DAOException;
import br.com.tom.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
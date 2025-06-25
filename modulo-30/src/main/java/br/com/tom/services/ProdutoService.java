/**
 * 
 */
package br.com.tom.services;

import br.com.tom.dao.IProdutoDAO;
import br.com.tom.domain.Produto;
import br.com.tom.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
package br.com.rpires.dao;

/**
 * @author rodrigo.pires
 */
public class ContratoDao implements IContratoDao {

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não salva com o banco");
    }

    public void buscar(){ throw new UnsupportedOperationException("Não busca com o banco."); }

    public void excluir(){ throw new UnsupportedOperationException("Não exclui com o banco."); }

    public void atualizar(){ throw new UnsupportedOperationException("Não atualiza com o banco."); }
}

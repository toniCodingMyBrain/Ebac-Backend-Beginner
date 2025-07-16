package tom.model.dao;

import tom.model.domain.Fornecedor;

import java.util.List;

public interface IFornecedor {
    void cadastrar(Fornecedor fornecedor);
    void alterar(Long fornecedorId, Fornecedor updatedFornecedor);
    Fornecedor buscarPorId(Long id);
    List<Fornecedor> buscaTodos();
    void excluirPorId(Long id);
}
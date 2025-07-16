package tom.model.dao;

import tom.model.domain.Produto;

import java.util.List;

public interface IProduto {
    void cadastrar(Produto produto);
    Produto buscarPorId(Long id);
    List<Produto> buscarTodos();
    List<Produto> buscarPorFornecedorId(Long fornecedorId);
    void excluir(Long id);
}
package tom.model.dao;

import tom.model.domain.Estoque;

import java.util.List;

public interface IEstoque {
    void cadastrar(Estoque estoque);
    void alterar(Long estoqueId, Estoque estoqueNovo);
    Estoque buscarPorId(Long id);
    List<Estoque> buscarTodos();
    Estoque buscarPorProdutoId(Long produtoId);
    void excluir(Long id);
}
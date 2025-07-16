package tom.model.dao;

import tom.model.domain.Produto;
import tom.model.service.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO implements IProduto {

    @Override
    public void cadastrar(Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            if (produto.getId() == null) {
                em.persist(produto);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Produto buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Produto.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Produto> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Produto> buscarPorFornecedorId(Long fornecedorId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em
                    .createQuery("SELECT p FROM Produto p WHERE p.fornecedor.id = :fornecedorId",
                            Produto.class)
                    .setParameter("fornecedorId", fornecedorId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, id);
            if(produto.getId() != null){
                em.remove(produto);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
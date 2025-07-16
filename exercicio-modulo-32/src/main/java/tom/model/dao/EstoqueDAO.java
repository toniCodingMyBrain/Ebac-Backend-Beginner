package tom.model.dao;

import tom.model.domain.Estoque;
import tom.model.service.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class EstoqueDAO implements IEstoque {
    @Override
    public void cadastrar(Estoque estoque) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            if (estoque.getId() == null) {
                em.persist(estoque);
            } else {
                em.merge(estoque);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void alterar(Long estoqueId, Estoque estoqueNovo) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            int updateQuery = em.createQuery("UPDATE Estoque " +
                            "SET quantidade = :novaQuantidade " +
                            "WHERE id = :estoqueId")
                    .setParameter("novaQuantidade", estoqueNovo.getQuantidade())
                    .setParameter("estoqueId", estoqueId)
                    .executeUpdate();
            if (updateQuery == 0) {
                throw new IllegalArgumentException("Fornecedor com ID: " + estoqueId + " não encontrado.");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Estoque buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Estoque.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Estoque> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Estoque e", Estoque.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Estoque buscarPorProdutoId(Long produtoId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Estoque e WHERE e.produto.id = :produtoId", Estoque.class)
                    .setParameter("produtoId", produtoId)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Estoque estoque = em.find(Estoque.class, id);
            if (estoque != null) {
                em.remove(estoque);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
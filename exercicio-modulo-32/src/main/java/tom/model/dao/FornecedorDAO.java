package tom.model.dao;

import tom.model.domain.Fornecedor;
import tom.model.service.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class FornecedorDAO implements IFornecedor {
    @Override
    public void cadastrar(Fornecedor fornecedor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            if (fornecedor.getId() == null) {
                em.persist(fornecedor);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void alterar(Long fornecedorId, Fornecedor updatedFornecedor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            int updateQuery = em.createQuery("UPDATE Fornecedor " +
                    "SET nome = :fornecedorNome, cnpj = :fornecedorCnpj " +
                    "WHERE id = :fornecedorId").setParameter("fornecedorNome", updatedFornecedor.getNome())
                    .setParameter("fornecedorCnpj", updatedFornecedor.getCnpj())
                    .setParameter("fornecedorId", fornecedorId)
                    .executeUpdate();
            if (updateQuery == 0) {
                throw new IllegalArgumentException("Fornecedor com ID: " + fornecedorId + " não encontrado.");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Fornecedor buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Fornecedor.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Fornecedor> buscaTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT f FROM Fornecedor f", Fornecedor.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluirPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Fornecedor fornecedor = em.find(Fornecedor.class, id);
            if (fornecedor != null) {
                em.remove(fornecedor);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
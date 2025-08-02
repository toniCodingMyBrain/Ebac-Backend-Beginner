package com.library.dao.implementations;

import com.library.dao.interfaces.IPublisherDAO;
import com.library.domain.Book;
import com.library.domain.Publisher;
import com.library.exceptions.InvalidParameterException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class PublisherDAOImpl implements IPublisherDAO {
    private final EntityManager entityManager;

    public PublisherDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void savePublisher(Publisher publisher) {
        entityManager.persist(publisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
    }

    @Override
    public List<Publisher> searchAllPublishers() {
        return List.of();
    }

    @Override
    public Publisher searchPublisherById(Long id) {
        return null;
    }

    @Override
    public void deletePublisherById(Long id) {
    }
}
package com.library.service;

import com.library.dao.implementations.PublisherDAOImpl;
import com.library.dao.interfaces.IPublisherDAO;
import com.library.domain.Publisher;
import com.library.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublisherServiceTest {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    private IPublisherDAO publisherDAO;
    private PublisherService publisherService;

    @BeforeEach
    void setUp() {
        entityManager = JPAUtil.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        publisherDAO = new PublisherDAOImpl(entityManager);
        publisherService = new PublisherService(publisherDAO);
    }

    @AfterEach
    void close(){
        if(entityManager.isOpen()){
            entityManager.close();
        }
    }

    @Test
    void cadastroDeEditora(){
        Publisher publisher = new Publisher();
        publisher.setName("Harper Collins");
        publisher.setCountry("England");

        entityTransaction.begin();
        int result = publisherService.createPublisher(publisher);
        entityTransaction.commit();

        assertEquals(1, result);

        Publisher publisherFound = entityManager.find(Publisher.class, publisher.getId());
        assertNotNull(publisherFound);
    }
}
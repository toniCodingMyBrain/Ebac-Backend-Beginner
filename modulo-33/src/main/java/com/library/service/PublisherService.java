package com.library.service;

import com.library.dao.interfaces.IPublisherDAO;
import com.library.domain.Publisher;
import com.library.exceptions.InvalidParameterException;
import com.library.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PublisherService {
    private final IPublisherDAO publisherDAO;

    public PublisherService(IPublisherDAO publisherDAO) {
        this.publisherDAO = publisherDAO;
    }

    public Integer createPublisher(Publisher publisher) {
        //? Checa se todos os dados enviados batem com as especificações
        if (publisher.getName() == null || publisher.getCountry() == null
                || publisher.getName().trim().isEmpty() || publisher.getCountry().trim().isEmpty()) {
            throw new InvalidParameterException("Os campos não podem ser nulos.");
        }

        //! Persistência de dados
        try {
            publisherDAO.savePublisher(publisher);
            return 1;
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
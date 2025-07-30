package com.library.dao.implementations;

import com.library.dao.interfaces.IPublisherDAO;
import com.library.domain.models.Publisher;

import java.util.List;

public class PublisherDAOImpl implements IPublisherDAO {
    @Override
    public Integer createPublisher(Publisher publisher) {
        return 0;
    }

    @Override
    public Integer updatePublisher(Publisher publisher) {
        return 0;
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
    public Integer deletePublisherById(Long id) {
        return 0;
    }
}
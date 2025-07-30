package com.library.dao.interfaces;

import com.library.domain.models.Publisher;

import java.util.List;

public interface IPublisherDAO {
    public Integer createPublisher(Publisher publisher);
    public Integer updatePublisher(Publisher publisher);
    public List<Publisher> searchAllPublishers();
    public Publisher searchPublisherById(Long id);
    public Integer deletePublisherById(Long id);
}
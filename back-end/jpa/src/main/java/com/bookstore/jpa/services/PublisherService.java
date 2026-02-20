package com.bookstore.jpa.services;

import com.bookstore.jpa.dtos.PublisherDto;
import com.bookstore.jpa.models.PublisherModel;
import com.bookstore.jpa.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;

@Service
public class PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    @Transactional
    public PublisherModel salvarPublisher(PublisherDto publisherDto){
        PublisherModel publisher = new PublisherModel();
        publisher.setName(publisherDto.name());
        return publisherRepository.save(publisher);
    }

}

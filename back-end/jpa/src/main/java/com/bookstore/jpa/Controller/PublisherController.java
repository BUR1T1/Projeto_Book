package com.bookstore.jpa.Controller;

import com.bookstore.jpa.dtos.PublisherDto;
import com.bookstore.jpa.models.PublisherModel;
import com.bookstore.jpa.services.PublisherService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @PostMapping("/crir-publicadora")
    public ResponseEntity<PublisherModel> criarPublisher(@RequestBody PublisherDto dto){
        PublisherModel salvarpublisher = publisherService.salvarPublisher(dto);
        return ResponseEntity.ok(salvarpublisher);

    }

}

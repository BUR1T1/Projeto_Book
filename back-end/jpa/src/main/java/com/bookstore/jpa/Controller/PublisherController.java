package com.bookstore.jpa.Controller;

import com.bookstore.jpa.dtos.PublisherDto;
import com.bookstore.jpa.models.PublisherModel;
import com.bookstore.jpa.repositories.PublisherRepository;
import com.bookstore.jpa.services.PublisherService;
import jakarta.persistence.Entity;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/Listar")
    public List<PublisherModel> listarPubliser(){
        return publisherService.findAllPublisher();
    }

    @GetMapping("/buscar-Publisher{id}")
    public ResponseEntity<PublisherModel> buscarAutorId(@PathVariable UUID id){
        Optional <PublisherModel> publisher = publisherService.findPublisherid(id);
        return publisher.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscarPorname{name}")
    public ResponseEntity<PublisherModel> buscarPorName(@PathVariable String name){
        Optional<PublisherModel> publisherModel = publisherService.findPubliserName(name);
        return publisherModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

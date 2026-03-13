package com.bookstore.jpa.Controller;

import com.bookstore.jpa.dtos.AutorDto;
import com.bookstore.jpa.models.AutorModel;
import com.bookstore.jpa.repositories.AutorRepository;
import com.bookstore.jpa.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/autors")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @Autowired
    AutorRepository autorRepository;


    @PostMapping("/criar-autor")
    public ResponseEntity <AutorModel> criarautor(@RequestBody AutorDto autorDto){
        AutorModel saveauthor = autorService.saveAutor(autorDto);
        return ResponseEntity.ok(saveauthor);
    }

    @GetMapping("listar-autor")
    public List<AutorModel> listarAutor(){
        return autorService.findAllAutor();
    }

    @GetMapping("/listar-autor{id}")
    public ResponseEntity<AutorModel> listarAutorPorID(@PathVariable UUID id){
        Optional<AutorModel> autorModel = autorService.findAutorByid(id);
        return autorModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}



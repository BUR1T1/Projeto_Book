package com.bookstore.jpa.Controller;

import com.bookstore.jpa.dtos.AutorDto;
import com.bookstore.jpa.models.AutorModel;
import com.bookstore.jpa.repositories.AutorRepository;
import com.bookstore.jpa.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}



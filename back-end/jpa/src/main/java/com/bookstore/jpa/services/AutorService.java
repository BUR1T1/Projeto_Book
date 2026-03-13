package com.bookstore.jpa.services;

import com.bookstore.jpa.dtos.AutorDto;
import com.bookstore.jpa.models.AutorModel;
import com.bookstore.jpa.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    @Transactional
    public AutorModel saveAutor(AutorDto autorDto){
        AutorModel author= new AutorModel();
        author.setName(autorDto.name());
        return autorRepository.save(author);

    }

    public List<AutorModel> findAllAutor(){
        return autorRepository.findAll();
    }

    public Optional<AutorModel> findAutorByid(UUID id){
        return autorRepository.findById(id);
    }

    public Optional<AutorModel> findByAutorname(String name){
        return autorRepository.findByName(name);
    }
}

package com.bookstore.jpa.services;

import com.bookstore.jpa.dtos.BookRecordDto;
import com.bookstore.jpa.dtos.PublisherDto;
import com.bookstore.jpa.models.*;
import com.bookstore.jpa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PublisherService publisherService;

    @Transactional
    public BookModel saveBook(BookRecordDto dto) {
        BookModel book = new BookModel();
        book.setTitle(dto.title());
        book.setCapa(dto.capa());
        book.getAutorReview(dto.autorReview());

        PublisherModel publisher = publisherRepository.findByName(dto.publisherName())
                .orElseGet(() -> {
                    PublisherModel newPub = new PublisherModel();
                    newPub.setName(dto.publisherName());
                    return publisherRepository.save(newPub);
                });
        book.setPublisher(publisher);

        // BUSCAR OU CRIAR AUTORES
        Set<AutorModel> authors = dto.autorname().stream()
                .map(name -> autorRepository.findByName(name)
                        .orElseGet(() -> {
                            AutorModel newAuthor = new AutorModel();
                            newAuthor.setName(name);
                            return autorRepository.save(newAuthor);
                        }))
                .collect(Collectors.toSet());

        book.setAutors(authors);

        // Lógica de Review existente
        if (dto.reviewComment() != null) {
            ReviewModel review = new ReviewModel();
            review.setComment(dto.reviewComment());
            review.setBook(book);
            book.setReview(review);
        }

        return bookRepository.saveAndFlush(book);
    }

    public List<BookModel> findBookAll(){ return bookRepository.findAll(); }

    public Optional<BookModel> findBookById(UUID id) {
        return bookRepository.findById(id);
    }

    public Optional<BookModel> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}

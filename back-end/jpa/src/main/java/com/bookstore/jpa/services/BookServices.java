package com.bookstore.jpa.services;

import com.bookstore.jpa.dtos.BookRecordDto;
import com.bookstore.jpa.models.*;
import com.bookstore.jpa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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

    @Transactional
    public BookModel saveBook(BookRecordDto dto) {
        BookModel book = new BookModel();
        book.setTitle(dto.title());

        // Buscar e vincular a Editora
        PublisherModel publisher = publisherRepository.findById(dto.publisherId())
                .orElseThrow(() -> new RuntimeException("Editora não encontrada"));
        book.setPublisher(publisher);

        // Buscar e vincular os Autores (Obrigatório)
        Set<AutorModel> authors = new HashSet<>(autorRepository.findAllById(dto.authorIds()));

        if (authors.isEmpty()) {
            throw new RuntimeException("É necessário informar ao menos um autor válido.");
        }

        if (dto.reviewComment() != null) {
            ReviewModel review = new ReviewModel();
            review.setComment(dto.reviewComment());

            // Vinculação bidirecional correta
            review.setBook(book);
            book.setReview(review);
        }

// Em vez de apenas salvar, vamos dar um flush
        book.setAutors(authors);
        return bookRepository.saveAndFlush(book);

    }

    public Optional<BookModel> findBookById(UUID id) {
        return bookRepository.findById(id);
    }

    public Optional<BookModel> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}

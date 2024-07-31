package com.bookstore.jpa.services;

import com.bookstore.jpa.dtos.BookRecordDto;
import com.bookstore.jpa.models.*;
import com.bookstore.jpa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public BookModel saveBook(BookRecordDto bookRecordDto) {
        BookModel book = new BookModel();
        book.setTitle(bookRecordDto.title());

        // Associar publisher
        Optional<PublisherModel> publisher = publisherRepository.findById(bookRecordDto.publisherId());
        publisher.ifPresent(book::setPublisher);

        // Associar autores
        Set<AutorModel> autors = bookRecordDto.authorsIds().stream()
                .map(autorRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
        book.setAutors(autors);

        // Associar review
        if (bookRecordDto.reviewComment() != null) {
            ReviewModel review = new ReviewModel();
            review.setComment(bookRecordDto.reviewComment());
            review.setBook(book);
            book.setReview(review);
        }

        return bookRepository.save(book);
    }

    public Optional<BookModel> findBookById(UUID id) {
        return bookRepository.findById(id);
    }

    public Optional<BookModel> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}

package com.bookstore.jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_books")
public class BookModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(name = "AUTOR_REVIW")
    private String autorReview;

    @Lob
    @Column(name = "CAPA_LIVRO", length = 50000,columnDefinition = "TEXT")
    private String capa;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherModel publisher;

    @ManyToMany
    @JoinTable(
            name ="tb_book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    @JsonIgnoreProperties("books")
    private Set<AutorModel> autors = new HashSet<>();

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private ReviewModel review;

    // Getters and Setters
    public Set<AutorModel> getAutors() {
        return autors;
    }

    public void setAutors(Set<AutorModel> autors) {
        this.autors = autors;
    }

    public ReviewModel getReview() {
        return review;
    }

    public void setReview(ReviewModel review) {
        this.review = review;
    }

    public PublisherModel getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherModel publisher) {
        this.publisher = publisher;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutorReview(String s){ return autorReview;}

    public void setAutorReview(String s) {this.autorReview = autorReview;}

    public String getCapa(){ return capa;}

    public void setCapa(String capa){ this.capa = capa; }

}

package com.bookstore.jpa.dtos;
import java.util.Set;

public record BookRecordDto(
        String title,
        String publisherName,
        Set<String> autorname,
        String autorReview,
        String reviewComment,
        String capa
) {}

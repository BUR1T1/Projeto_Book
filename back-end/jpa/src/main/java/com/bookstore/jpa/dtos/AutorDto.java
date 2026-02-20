package com.bookstore.jpa.dtos;

import jakarta.validation.constraints.NotNull;

public record AutorDto(
        @NotNull String name) {
}

package com.bookstore.jpa.repositories;

import com.bookstore.jpa.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PublisherRepository extends JpaRepository <PublisherModel, UUID> {

    Optional<PublisherModel> findByName(String name);
}

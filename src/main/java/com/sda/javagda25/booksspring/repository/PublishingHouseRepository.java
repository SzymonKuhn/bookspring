package com.sda.javagda25.booksspring.repository;

import com.sda.javagda25.booksspring.model.PublishingHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingHouseRepository extends JpaRepository <PublishingHouse, Long> {
}

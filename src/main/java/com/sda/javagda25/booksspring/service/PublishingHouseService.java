package com.sda.javagda25.booksspring.service;

import com.sda.javagda25.booksspring.model.PublishingHouse;
import com.sda.javagda25.booksspring.repository.PublishingHouseRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PublishingHouseService {
    private final PublishingHouseRepository publishingHouseRepository;

    public void addPublishingHouse (PublishingHouse publishingHouse){
        publishingHouseRepository.save(publishingHouse);
    }

    public List<PublishingHouse> getAll () {
        return publishingHouseRepository.findAll();
    }

    public Optional<PublishingHouse> getById (Long id) {
        return publishingHouseRepository.findById(id);
    }

    public void delete (PublishingHouse publishingHouse) {
        publishingHouseRepository.delete(publishingHouse);
    }
}

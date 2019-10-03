package com.sda.javagda25.booksspring.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PublishingHouse  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "publishingHouse")
    private Set<Book> books;

    public PublishingHouse(String name) {
        this.name = name;
    }
}

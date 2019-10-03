package com.sda.javagda25.booksspring.model;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int yearWritten;
    private int numOfPages;
    private int numOfAllCopies;

//    @Formula(value="(SELECT COUNT(*) FROM booklent bl WHERE bl.book_id = id and bl.dateReturned is null)")
//    private int numOfBorrowedCopies;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
//    private Set<BookLent> currentLents;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
//    private Set<Author> authors;

    @Formula(value = "(year(now()) - year_written)")
    private int howOld;

    @ManyToOne (fetch = FetchType.EAGER)
    private PublishingHouse publishingHouse;

    public Book(String title, int yearWritten, int numOfPages, int numOfAllCopies) {
        this.title = title;
        this.yearWritten = yearWritten;
        this.numOfPages = numOfPages;
        this.numOfAllCopies = numOfAllCopies;
    }
}


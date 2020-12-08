package com.goodreads.goodreads.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookName;
    private int bookPage;
    private LocalDate bookUpdateDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
    private List<Comment> bookCommentList = new ArrayList<Comment>();

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authorSet = new HashSet<Author>();

    @ManyToMany
    @JoinTable(name = "book_publisher",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "publisher_id")})
    private Set<Publisher> publisherSet = new HashSet<Publisher>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Set<Type> typeSet = new HashSet<>();
}

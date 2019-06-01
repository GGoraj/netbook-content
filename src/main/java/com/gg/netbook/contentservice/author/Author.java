package com.gg.netbook.contentservice.author;


import com.gg.netbook.contentservice.book.Book;

import org.hibernate.search.annotations.*;


import javax.persistence.*;
import java.util.Set;

@Entity
@Indexed
@Table(name = "author")
public class Author {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;


    @Column(name="fullname")
    public String fullName;


    @ManyToMany
    @JoinTable(
            name = "authors_books",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books;




    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



}
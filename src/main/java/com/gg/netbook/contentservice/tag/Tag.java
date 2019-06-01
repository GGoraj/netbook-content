package com.gg.netbook.contentservice.tag;

import com.gg.netbook.contentservice.book.Book;
import com.gg.netbook.contentservice.tags_books.TagsBooks;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="tagname")
    private String tagName;


    @OneToMany(mappedBy = "tag")
    private Set<TagsBooks> books;



    public Tag() {
        // blank
    }

    public Tag(String tagName) {

        this.tagName = tagName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<TagsBooks> getBooks() {
        return books;
    }

    public void setBooks(Set<TagsBooks> books) {
        this.books = books;
    }


}

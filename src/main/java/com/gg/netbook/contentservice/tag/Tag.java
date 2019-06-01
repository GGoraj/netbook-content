/*
package com.gg.netbook.contentservice.tag;

import com.gg.netbook.contentservice.book.Book;

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


    @ManyToMany
    @JoinTable(
            name = "tags_books",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books;



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
}
*/

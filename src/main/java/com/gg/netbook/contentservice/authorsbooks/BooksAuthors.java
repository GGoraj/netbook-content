package com.gg.netbook.contentservice.authorsbooks;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="booksauthors")
public class BooksAuthors implements Serializable {

    @Id
    @Column(name="authorid")
    private Integer authorId;

    @Id
    @Column(name="bookid")
    private Integer bookId;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

}

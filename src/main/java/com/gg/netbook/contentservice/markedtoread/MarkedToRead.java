/*
package com.gg.netbook.contentservice.markedtoread;

import com.gg.netbook.contentservice.book.Book;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="markedtoread")
public class MarkedToRead implements Serializable {


    @EmbeddedId
    MarkedToReadKey id;

    @ManyToOne
    @MapsId("book_id")
    @JoinColumn(name = "book_id")
    Book book;



}
*/

package com.gg.netbook.contentservice.markedtoread;

import com.gg.netbook.contentservice.book.Book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="markedtoread")
public class MarkedToRead implements Serializable{

    @Id
    @Column(name="id")
    Integer id;



    @Column(name = "user_id")
    Integer user_id;

    @Column(name = "book_id")
    Integer book_id;

}

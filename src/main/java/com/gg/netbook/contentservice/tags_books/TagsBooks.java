package com.gg.netbook.contentservice.tags_books;


import com.gg.netbook.contentservice.book.Book;
import com.gg.netbook.contentservice.tag.Tag;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tags_books")
public class TagsBooks implements Serializable {

    @EmbeddedId
    private TagsBooksKey id;

    @ManyToOne
    @MapsId("goodreadsbook_id")
    @JoinColumn(name = "goodreadsbook_id")
    private Book book;

    @ManyToOne
    @MapsId("tag_id")
    @JoinColumn(name = "tag_id")
    private Tag tag;

    private Integer counter;





}

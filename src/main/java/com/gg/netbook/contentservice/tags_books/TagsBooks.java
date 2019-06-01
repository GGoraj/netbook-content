/*
package com.gg.netbook.contentservice.tags_books;


import com.gg.netbook.contentservice.book.Book;
import com.gg.netbook.contentservice.tag.Tag;

import javax.persistence.*;

@Entity
@Table(name = "tags_books")
public class TagsBooks {

    @EmbeddedId
    TagsBooksKey id;

    @ManyToOne
    @MapsId("goodreadsbook_id")
    @JoinColumn(name = "goodreadsbook_id")
    Book book;

    @ManyToOne
    @MapsId("tag_id")
    @JoinColumn(name = "tag_id")
    Tag tag;





}
*/

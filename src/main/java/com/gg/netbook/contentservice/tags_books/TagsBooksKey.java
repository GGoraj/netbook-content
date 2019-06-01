package com.gg.netbook.contentservice.tags_books;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TagsBooksKey implements Serializable {


    @Column(name="goodreadsbook_id")
    private Integer goodReadsBookId;

    @Column(name= "tag_id")
    private Integer tagId;




    public TagsBooksKey(Integer bookIdd, Integer tagId) {
        this.goodReadsBookId = bookIdd;
        this.tagId = tagId;
    }

    public TagsBooksKey() {
        //empty
    }

    public Integer getGoodReadsBookId() {
        return goodReadsBookId;
    }

    public void setGoodReadsBookId(Integer goodReadsBookId) {
        this.goodReadsBookId = goodReadsBookId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}

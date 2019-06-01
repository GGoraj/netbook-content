package com.gg.netbook.contentservice.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gg.netbook.contentservice.author.Author;
import com.gg.netbook.contentservice.tag.Tag;
import com.gg.netbook.contentservice.tags_books.TagsBooks;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "goodreadsbook_id")
    private Integer goodreadsbook_Id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "originalpublicationyear")
    private String originalpublicationyear;

    @Column(name = "originaltitle")
    private String originaltitle;

    @Column(name = "internationaltitle")
    private String internationaltitle;

    @Column(name = "languagecode")
    private String languagecode;

    @Column(name = "averagerating")
    private BigDecimal averagerating;

    @Column(name = "ratingscount")
    private Integer ratingscount;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "smallimageurl")
    private String smallimageurl;

    @Column(name = "bookurl")
    private String bookurl;

    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    Set<Author> authors;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    Set<TagsBooks> tags;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodreadsbook_Id() {
        return goodreadsbook_Id;
    }

    public void setGoodreadsbook_Id(Integer goodreadsbook_Id) {
        this.goodreadsbook_Id = goodreadsbook_Id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getOriginalpublicationyear() {
        return originalpublicationyear;
    }

    public void setOriginalpublicationyear(String originalpublicationyear) {
        this.originalpublicationyear = originalpublicationyear;
    }

    public String getOriginaltitle() {
        return originaltitle;
    }

    public void setOriginaltitle(String originaltitle) {
        this.originaltitle = originaltitle;
    }

    public String getInternationaltitle() {
        return internationaltitle;
    }

    public void setInternationaltitle(String internationaltitle) {
        this.internationaltitle = internationaltitle;
    }

    public String getLanguagecode() {
        return languagecode;
    }

    public void setLanguagecode(String languagecode) {
        this.languagecode = languagecode;
    }

    public BigDecimal getAveragerating() {
        return averagerating;
    }

    public void setAveragerating(BigDecimal averagerating) {
        this.averagerating = averagerating;
    }

    public Integer getRatingscount() {
        return ratingscount;
    }

    public void setRatingscount(Integer ratingscount) {
        this.ratingscount = ratingscount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSmallimageurl() {
        return smallimageurl;
    }

    public void setSmallimageurl(String smallimageurl) {
        this.smallimageurl = smallimageurl;
    }

    public String getBookurl() {
        return bookurl;
    }

    public void setBookurl(String bookurl) {
        this.bookurl = bookurl;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<TagsBooks> getTags() {
        return tags;
    }

    public void setTags(Set<TagsBooks> tags) {
        this.tags = tags;
    }
}
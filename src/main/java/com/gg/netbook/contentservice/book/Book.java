package com.gg.netbook.contentservice.book;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookid;

    @Column(name="goodreadsbookid")
    private Integer goodReadsBookId;

    @Column(name="isbn")
    private String isbn;

    @Column(name="originalpublicationyear")
    private String originalPublicationYear;

    @Column(name="originaltitle")
    private String originalTitle;

    @Column(name="internationaltitle")
    private String internationalTitle;

    @Column(name="languagecode")
    private String languageCode;

    @Column(name="averagerating")
    private BigDecimal averageRating;

    @Column(name="ratingscount")
    private Integer ratingsCount;

    @Column(name="imageurl")
    private String imageUrl;

    @Column(name="smallimageurl")
    private String smallImageUrl;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getGoodReadsBookId() {
        return goodReadsBookId;
    }

    public void setGoodReadsBookId(Integer goodReadsBookId) {
        this.goodReadsBookId = goodReadsBookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getOriginalPublicationYear() {
        return originalPublicationYear;
    }

    public void setOriginalPublicationYear(String originalPublicationYear) {
        this.originalPublicationYear = originalPublicationYear;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getInternationalTitle() {
        return internationalTitle;
    }

    public void setInternationalTitle(String internationalTitle) {
        this.internationalTitle = internationalTitle;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }






}
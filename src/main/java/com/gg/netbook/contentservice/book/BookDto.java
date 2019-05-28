package com.gg.netbook.contentservice.book;

import java.math.BigDecimal;

public class BookDto {

    private Integer bookid;
    private Integer goodReadsBookId;
    private String isbn;
    private String originalPublicationYear;
    private String originalTitle;
    private String internationalTitle;
    private String languageCode;
    private BigDecimal averageRating;
    private Integer ratingsCount;
    private String imageUrl;
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

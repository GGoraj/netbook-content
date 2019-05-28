package com.gg.netbook.contentservice.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class BookService {

    @Autowired
    BookRepository repository;

    public void add(BookDto dto){
        repository.save(toEntity(dto));
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public List<Book> getAllBooks() {
        List<Book> books;
        books = repository.findAll();
        return books;
    }

    public Book getBookById(Integer bookid){
        Optional<Book> optionalBookEntity = repository.findById(bookid);
        return optionalBookEntity.orElseThrow(() -> new BookEntityNotFoundException("Couldn't find a Book with bookid: " + bookid));
    }

    private Book toEntity(BookDto dto) {
        Book entity = new Book();

        entity.setGoodReadsBookId(entity.getGoodReadsBookId());
        entity.setIsbn(entity.getIsbn());
        entity.setOriginalPublicationYear(entity.getOriginalPublicationYear());
        entity.setOriginalTitle(dto.getOriginalTitle());
        entity.setInternationalTitle(dto.getInternationalTitle());
        entity.setLanguageCode(dto.getLanguageCode());
        entity.setAverageRating(dto.getAverageRating());
        entity.setRatingsCount(dto.getRatingsCount());
        entity.setImageUrl(dto.getImageUrl());
        entity.setSmallImageUrl(dto.getImageUrl());

        return entity;
    }
}

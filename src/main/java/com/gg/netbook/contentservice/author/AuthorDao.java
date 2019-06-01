package com.gg.netbook.contentservice.author;

import com.gg.netbook.contentservice.book.Book;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AuthorDao<T> {

    Optional<T> get(int id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);

    //Set<Book> getAuthorBooks(int author_id);
}

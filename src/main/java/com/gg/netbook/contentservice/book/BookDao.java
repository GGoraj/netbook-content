package com.gg.netbook.contentservice.book;

import com.gg.netbook.contentservice.author.Author;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BookDao<T> {

    Optional<Book> get(int id);


    List<T> getAll(int limit);

    Set<Author> getBookAuthors(int id);

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);


}

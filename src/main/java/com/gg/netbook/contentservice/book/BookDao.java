package com.gg.netbook.contentservice.book;

import com.gg.netbook.contentservice.author.Author;

import java.util.List;
import java.util.Optional;

public interface BookDao<T> {

    Optional<T> get(int id);

    List<T> getAll(int limit);

    List<Author> getBookAuthors(int id);

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);


}

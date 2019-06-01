package com.gg.netbook.contentservice.book;

import java.util.List;
import java.util.Optional;

public interface BookDao<T> {

    Optional<Book> get(int id);


    List<T> getAll(int limit);

    String getBookAuthors(int id);

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);


}

package com.gg.netbook.contentservice.markedtoread;

import com.gg.netbook.contentservice.book.Book;

import java.util.List;

public interface MarkedToReadDao<T> {

    List<Book> get(int user_id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);

}

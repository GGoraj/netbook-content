package com.gg.netbook.contentservice.book;

import java.util.List;
import java.util.Optional;

public interface BookDao<T> {

    Optional<T> get(int id);

    List<T> getAll(int limit);

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);

}

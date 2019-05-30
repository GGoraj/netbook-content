package com.gg.netbook.contentservice.books;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Component
public class JpaBookDao implements BookDao<Book> {



    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Book> get(int id) {

        Optional<Book> book = Optional.ofNullable(em.find(Book.class, id));
        return book;
    }

    @Override
    public List<Book> getAll(int limit) {

        String q = "SELECT b FROM Book b ORDER BY b.bookid";
        Query query = em.createQuery(q, Book.class).setMaxResults(limit);

        return query.getResultList();

    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void update(Book book, String[] params) {

    }

    @Override
    public void delete(Book book) {

    }
}

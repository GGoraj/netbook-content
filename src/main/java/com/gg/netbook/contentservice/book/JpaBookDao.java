package com.gg.netbook.contentservice.book;

import com.gg.netbook.contentservice.author.Author;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

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

        String q = "SELECT b FROM Book b ORDER BY b.id";
        Query query = em.createQuery(q, Book.class).setMaxResults(limit);

        return query.getResultList();

    }

    @Override
    public List<Author> getBookAuthors(int id) {

        Optional<Book> opt = Optional.ofNullable(em.find(Book.class, id));
        Set<Author> authors = (Set<Author>) opt.get().authors;

        if(authors.isEmpty()){
            return null;
        }

        ArrayList<Author> listAuthors = new ArrayList<>();
        Iterator iterator = authors.iterator();
        while(iterator.hasNext()) {
            Author author = (Author) iterator.next();
            Author a = new Author();
            a.setId(author.getId());
            a.setFullName(author.getFullName());
            listAuthors.add(a);
        }
        return listAuthors;

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

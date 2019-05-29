package com.gg.netbook.contentservice.authors;

import com.gg.netbook.contentservice.interfaces.Dao;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


@Component
public class JpaAuthorDao implements Dao<Author> {


    @Autowired
    private EntityManager entityManager;



    @Override
    public Optional<Author> get(int authorId) {
        return Optional.ofNullable(entityManager.find(Author.class, authorId));
    }

    @Override
    public List<Author> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Author e");
        return query.getResultList();
    }

    @Override
    public void save(Author author) {

    }

    @Override
    public void update(Author author, String[] params) {

    }

    @Override
    public void delete(Author author) {

    }
}

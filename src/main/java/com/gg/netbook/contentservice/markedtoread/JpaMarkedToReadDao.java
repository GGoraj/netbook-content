package com.gg.netbook.contentservice.markedtoread;

import com.gg.netbook.contentservice.book.Book;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class JpaMarkedToReadDao implements MarkedToReadDao<MarkedToRead> {


    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Book> get(int id) {

        Query query = em.createNativeQuery("SELECT * FROM BOOK WHERE id IN (SELECT book_id FROM MarkedToRead WHERE user_id=?)");
        query.setParameter(1, id);
        List<Book> list = query.getResultList();
        return list;
    }


    @Override
    public List<MarkedToRead> getAll() {
        return null;
    }


    @Override
    public void save(MarkedToRead markedToRead) {
        // not implemented
    }

    @Override
    public void update(MarkedToRead markedToRead, String[] params) {
        // not implemented
    }

    @Override
    public void delete(MarkedToRead markedToRead) {
        // not implemented
    }


}

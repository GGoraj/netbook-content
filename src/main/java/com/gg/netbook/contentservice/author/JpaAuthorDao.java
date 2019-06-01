package com.gg.netbook.contentservice.author;

import com.gg.netbook.contentservice.book.Book;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Component
public class JpaAuthorDao implements AuthorDao<Author> {


    @PersistenceContext
    private EntityManager em;


    @Override
    public Optional<Author> get(int authorId) {
        return Optional.ofNullable(em.find(Author.class, authorId));
    }

    @Override
    public List<Author> getAll() {

        javax.persistence.Query query = em.createQuery("select e from Author e");
        return query.getResultList();

    }


  /*  @Override
    public Set<Book> getAuthorBooks(int author_id) {

        Optional<Author> opt = get(author_id);
        Set<Book> books= opt.get().getBooks();
        return books;
    }
*/

    @Override
    public void save(Author author) {

    }

    @Override
    public void update(Author author, String[] params) {

    }

    @Override
    public void delete(Author author) {

    }


    public List<Author> searchFuzzyAuthorName(String text) {

        Query fuzzyQuery = getQueryBuilder()
                .phrase()
                //.withSlop(1)
                .onField("fullname")
                .sentence(text)
                .createQuery();

        List<Author> resultList = getJpaQuery(fuzzyQuery).getResultList();

        System.out.println("***********************  " + resultList.size());
        return resultList;
    }


    private FullTextQuery getJpaQuery(org.apache.lucene.search.Query luceneQuery) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);

        return fullTextEntityManager.createFullTextQuery(luceneQuery, Author.class);
    }

    private QueryBuilder getQueryBuilder() {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);

        return fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Author.class)
                .get();
    }
}

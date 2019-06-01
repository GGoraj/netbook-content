package com.gg.netbook.contentservice.book;

import com.gg.netbook.contentservice.author.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired JpaBookDao jpaBookDao;

    @GetMapping("/allbooks")
    public List<Book> getAllBooks(){
        return jpaBookDao.getAll(20);
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Integer id){
        return jpaBookDao.get(id);
    }

    @GetMapping("book/authors/{id}")
    public String getBookAuthors(@PathVariable("id") Integer id){
        return jpaBookDao.getBookAuthors(id);
    }
}
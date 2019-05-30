package com.gg.netbook.contentservice.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
}
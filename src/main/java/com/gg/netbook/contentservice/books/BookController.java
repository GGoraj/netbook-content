package com.gg.netbook.contentservice.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class BookController {

    @Autowired BookService service;

    @GetMapping("/allbooks")
    @CrossOrigin(origins = "*")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") Integer id){
        return service.getBookById(id);
    }
}
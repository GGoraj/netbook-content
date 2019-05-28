package com.gg.netbook.contentservice.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired BookService service;

    @GetMapping("/allbooks")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") Integer id){
        return service.getBookById(id);
    }
}
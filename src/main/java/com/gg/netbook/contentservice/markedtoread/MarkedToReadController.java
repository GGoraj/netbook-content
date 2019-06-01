package com.gg.netbook.contentservice.markedtoread;


import com.gg.netbook.contentservice.book.Book;
import com.gg.netbook.contentservice.book.JpaBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class MarkedToReadController {

    @Autowired
    JpaMarkedToReadDao dao;

 @GetMapping("/user/bookstoread/{id}")
    public List<Book> getBookById(@PathVariable("id") int id){
        return dao.get(id);
    }


}

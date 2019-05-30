package com.gg.netbook.contentservice.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class AuthorController {

    @Autowired
    JpaAuthorDao authorDao;

    @GetMapping("/authors")
    public List<Author> getAllAuthors(){
        return authorDao.getAll();
    }

    @GetMapping("/author/{id}")
    public Optional<Author> getAuthor(@PathVariable("id") int id){
        System.out.println("********************" + String.valueOf(authorDao.get(id)));
        return authorDao.get(id);
    }

    // Full Text search - Name
    @GetMapping("/authors/fuzzy/{name}")
    public List<Author> getAuthorFullSearch(@PathVariable("name") String name){
        return authorDao.searchFuzzyAuthorName(name);
    }

}

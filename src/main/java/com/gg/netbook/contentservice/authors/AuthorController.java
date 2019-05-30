package com.gg.netbook.contentservice.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
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

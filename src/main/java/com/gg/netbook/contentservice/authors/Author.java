package com.gg.netbook.contentservice.authors;


import org.hibernate.search.annotations.*;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;

@Entity
@Indexed
@Table(name = "authors")
public class Author {

    @Id
    @Column(name="authorid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer authorId;


    @Column(name="fullname")
    @Field
    public String fullName;


    public Author(){
        // empty
    }

    public Author(String fullName) {
        this.fullName = fullName;
    }





    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

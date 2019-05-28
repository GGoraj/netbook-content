package com.gg.netbook.contentservice.authorsbooks;

import com.gg.netbook.contentservice.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsBooksRepository extends JpaRepository<Book, Integer> {


}

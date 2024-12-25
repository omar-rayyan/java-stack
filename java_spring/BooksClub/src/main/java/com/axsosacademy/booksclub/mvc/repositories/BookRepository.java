package com.axsosacademy.booksclub.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.booksclub.mvc.models.Book;
import com.axsosacademy.booksclub.mvc.models.User;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
    List<Book> findAll();
    Book findByUser(User user);
}
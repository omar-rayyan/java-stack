package com.axsosacademy.booksclub.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsosacademy.booksclub.mvc.models.Book;
import com.axsosacademy.booksclub.mvc.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	public void addBook(Book book){
		bookRepository.save(book);
	}
	
	public List<Book> getAll(){
	    return bookRepository.findAll();
	
	}
	
	public void create(Book book){
		bookRepository.save(book);
	}

	public Book findBookById(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
	}
}
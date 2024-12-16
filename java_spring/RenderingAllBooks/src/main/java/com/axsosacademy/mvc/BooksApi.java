package com.axsosacademy.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsosacademy.mvc.models.Book;
import com.axsosacademy.mvc.services.BookService;

@RestController
public class BooksApi {
    private final BookService bookService;
    
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(
            @PathVariable("id") Long id, 
            @RequestParam(value="title") String title, 
            @RequestParam(value="description") String desc, 
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
    
    @RequestMapping(value="/api/books/create", method=RequestMethod.POST)
    public Book createBook(
            @RequestParam(value="title") String title, 
            @RequestParam(value="description") String desc, 
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {
    	Book b = new Book(title, desc,lang,numOfPages);
    	
        bookService.createBook( b);
        return b;
    }
    
}
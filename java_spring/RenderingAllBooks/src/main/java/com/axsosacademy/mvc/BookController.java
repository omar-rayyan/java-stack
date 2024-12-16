package com.axsosacademy.mvc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsosacademy.mvc.models.Book;
import com.axsosacademy.mvc.services.BookService;

@Controller
public class BookController {
    private final BookService bookService;
    
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.GET)
    public String viewBook(Model model, @PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "index.jsp";
    }
    
    @RequestMapping(value="/books", method=RequestMethod.GET)
    public String viewAllBook(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "all_books.jsp";
    }
    
}
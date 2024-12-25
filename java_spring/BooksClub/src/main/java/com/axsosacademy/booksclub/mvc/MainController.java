package com.axsosacademy.booksclub.mvc;

import com.axsosacademy.booksclub.mvc.models.Book;
import com.axsosacademy.booksclub.mvc.models.LoginUser;
import com.axsosacademy.booksclub.mvc.models.User;
import com.axsosacademy.booksclub.mvc.services.BookService;
import com.axsosacademy.booksclub.mvc.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final UserService userService;
    private final BookService bookService;
    public MainController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }

    @GetMapping("/books")
    public String books(HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") != null) {
        	model.addAttribute("books", bookService.getAll());
            return "home.jsp";
        }
        else {
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult bindingResult,
            Model model, HttpSession session){
        User loggedUser = userService.register(newUser,bindingResult);
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        else {
            session.setAttribute("loggedUser", loggedUser);
            return "redirect:/books";
        }
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult bindingResult,
            HttpSession session,Model model) {
        User loggedUser = userService.login(newLogin, bindingResult);
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        else {
            session.setAttribute("loggedUser", loggedUser);
            return "redirect:/books";
        }
    }
    
    @GetMapping("/books/new")
    public String addBookForm(Model model, HttpSession session) {
    	if (session.getAttribute("loggedUser") != null) {
    		model.addAttribute("book", new Book());
            return "add_book.jsp";
        }
        else {
            return "redirect:/";
        }
    }
    
    @GetMapping("/books/{id}")
    public String viewBook(Model model, HttpSession session, @PathVariable("id") Long id) {
    	if (session.getAttribute("loggedUser") != null) {
    		model.addAttribute("book", bookService.findBookById(id));
            return "view_book.jsp";
        }
        else {
            return "redirect:/";
        }
    }

    @PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "add_book.jsp";
        }
        book.setUser((User)session.getAttribute("loggedUser"));
        bookService.create(book);
        return "redirect:/books";
    }
}
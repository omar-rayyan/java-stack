package com.axsosacademy.productsandcategories.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.axsosacademy.productsandcategories.mvc.services.CategoryService;
import com.axsosacademy.productsandcategories.mvc.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
    private CategoryService categoryService;
	
	@Autowired
    private ProductService productService;
	
	@GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "home.jsp";
    }
}

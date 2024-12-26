package com.axsosacademy.productsandcategories.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.axsosacademy.productsandcategories.mvc.models.Category;
import com.axsosacademy.productsandcategories.mvc.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/new")
    public String newCategory(Model model) {
        model.addAttribute("category", new Category());
        return "new_category.jsp";
    }

    @PostMapping("/new")
    public String createCategory(@ModelAttribute Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	model.addAttribute("category", new Category());
            return "new_category.jsp";
        }
        else {
        	categoryService.save(category);
            return "redirect:/";
        }
    }

    @GetMapping("/{id}")
    public String viewCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        model.addAttribute("availableProducts", categoryService.findUnlinkedProducts(category));
        return "view_category.jsp";
    }

    @PostMapping("/{id}/addProduct")
    public String addProductToCategory(@PathVariable Long id, @RequestParam Long productId) {
        categoryService.addProduct(id, productId);
        return "redirect:/categories/" + id;
    }
    
    @PostMapping("/{id}/removeProduct")
    public String removeProduct(@PathVariable Long id, @RequestParam Long productId) {
        categoryService.removeProductFromCategory(id, productId);
        return "redirect:/categories/" + id;
    }
}
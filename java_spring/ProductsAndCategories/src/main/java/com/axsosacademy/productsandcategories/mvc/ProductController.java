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
import com.axsosacademy.productsandcategories.mvc.models.Product;
import com.axsosacademy.productsandcategories.mvc.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new_product.jsp";
    }

    @PostMapping("/new")
    public String createProduct(@ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	model.addAttribute("product", new Product());
            return "new_product.jsp";
        }
        else {
        	productService.save(product);
            return "redirect:/";
        }
    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("availableCategories", productService.findUnlinkedCategories(product));
        return "view_product.jsp";
    }

    @PostMapping("/{id}/addCategory")
    public String addCategory(@PathVariable Long id, @RequestParam Long categoryId) {
        productService.addCategory(id, categoryId);
        return "redirect:/products/" + id;
    }
    
    @PostMapping("/{id}/removeCategory")
    public String removeCategory(@PathVariable Long id, @RequestParam Long categoryId) {
        productService.removeCategoryFromProduct(id, categoryId);
        return "redirect:/products/" + id;
    }
}
package com.axsosacademy.productsandcategories.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsosacademy.productsandcategories.mvc.models.Category;
import com.axsosacademy.productsandcategories.mvc.models.Product;
import com.axsosacademy.productsandcategories.mvc.repositories.ProductRepository;
import com.axsosacademy.productsandcategories.mvc.repositories.CategoryRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
    	Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void addCategory(Long productId, Long categoryId) {
        Product product = findById(productId);
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        product.getCategories().add(category);
        productRepository.save(product);
    }
    
    public void removeCategoryFromProduct(Long productId, Long categoryId) {
    	Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()) {
        	Product product = optionalProduct.get();
            Category category = categoryService.findById(categoryId);
            product.getCategories().remove(category);
            productRepository.save(product);
        }
    }

    public List<Category> findUnlinkedCategories(Product product) {
        List<Category> allCategories = categoryRepository.findAll();
        allCategories.removeAll(product.getCategories());
        return allCategories;
    }
}
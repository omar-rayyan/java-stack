package com.axsosacademy.productsandcategories.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsosacademy.productsandcategories.mvc.models.Category;
import com.axsosacademy.productsandcategories.mvc.models.Product;
import com.axsosacademy.productsandcategories.mvc.repositories.CategoryRepository;
import com.axsosacademy.productsandcategories.mvc.repositories.ProductRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
    public void removeProductFromCategory(Long categoryId, Long productId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalCategory.isPresent() && optionalProduct.isPresent()) {
            Category category = optionalCategory.get();
            Product product = optionalProduct.get();
            category.getProducts().remove(product);
            categoryRepository.save(category);
        }
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void addProduct(Long categoryId, Long productId) {
        Category category = findById(categoryId);
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        category.getProducts().add(product);
        categoryRepository.save(category);
    }

    public List<Product> findUnlinkedProducts(Category category) {
        List<Product> allProducts = productRepository.findAll();
        allProducts.removeAll(category.getProducts());
        return allProducts;
    }
}

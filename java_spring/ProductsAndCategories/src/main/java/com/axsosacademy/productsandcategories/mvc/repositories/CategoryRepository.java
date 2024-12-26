package com.axsosacademy.productsandcategories.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.productsandcategories.mvc.models.Category;
import com.axsosacademy.productsandcategories.mvc.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    List<Category> findByProductsNotContains(Product product);
}
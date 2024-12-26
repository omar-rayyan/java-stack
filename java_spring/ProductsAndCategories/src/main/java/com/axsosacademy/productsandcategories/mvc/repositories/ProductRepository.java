package com.axsosacademy.productsandcategories.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.productsandcategories.mvc.models.Product;
import com.axsosacademy.productsandcategories.mvc.models.Category;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findAll();
    List<Product> findByCategoriesNotContains(Category category);
}
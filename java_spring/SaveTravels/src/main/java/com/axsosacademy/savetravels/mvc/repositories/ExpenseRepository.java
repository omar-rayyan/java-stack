package com.axsosacademy.savetravels.mvc.repositories;

import java.util.List;

import com.axsosacademy.savetravels.mvc.models.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
    // this method retrieves all the books from the database
    List<Expense> findAll();
}
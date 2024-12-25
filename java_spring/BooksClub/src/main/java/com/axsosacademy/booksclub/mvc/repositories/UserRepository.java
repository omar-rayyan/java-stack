package com.axsosacademy.booksclub.mvc.repositories;

import com.axsosacademy.booksclub.mvc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
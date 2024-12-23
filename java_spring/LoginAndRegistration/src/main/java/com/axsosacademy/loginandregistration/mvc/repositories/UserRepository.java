package com.axsosacademy.loginandregistration.mvc.repositories;

import com.axsosacademy.loginandregistration.mvc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
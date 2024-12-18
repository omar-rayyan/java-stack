package com.axsosacademy.burgertrackerii.mvc.services;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import com.axsosacademy.burgertrackerii.mvc.models.Burger;
import com.axsosacademy.burgertrackerii.mvc.repositories.BurgerRepository;

@Service
public class BurgerService {

    private final BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }

    public Burger createBurger(Burger burger) {
        return burgerRepository.save(burger);
    }

    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        return optionalBurger.orElse(null);
    }

    public void updateBurger(Burger burger) {
        burgerRepository.save(burger);
    }
}
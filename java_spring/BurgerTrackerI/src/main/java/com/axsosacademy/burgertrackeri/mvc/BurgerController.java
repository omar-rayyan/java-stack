package com.axsosacademy.burgertrackeri.mvc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsosacademy.burgertrackeri.mvc.models.Burger;
import com.axsosacademy.burgertrackeri.mvc.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
    private final BurgerService burgerService;
    
    public BurgerController(BurgerService burgerService){
        this.burgerService = burgerService;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String viewAllBurgers(Model model, @ModelAttribute("burger") Burger burger) {
        List<Burger> burgers = burgerService.allBurgers();
        model.addAttribute("burgers", burgers);
        return "index.jsp";
    }
    
    @PostMapping("/createburger")
    public String createBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	System.out.println(result.getAllErrors());
        	model.addAttribute("burgers", burgerService.allBurgers());
            return "index.jsp";
        } else {
        	burgerService.createBurger(burger);
            return "redirect:/";
        }
    }
    
}
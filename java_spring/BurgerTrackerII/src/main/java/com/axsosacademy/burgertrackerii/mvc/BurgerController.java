package com.axsosacademy.burgertrackerii.mvc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.axsosacademy.burgertrackerii.mvc.models.Burger;
import com.axsosacademy.burgertrackerii.mvc.services.BurgerService;

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

    @RequestMapping(value="/burgers/edit/{id}", method=RequestMethod.GET)
    public String viewEditBurger(@ModelAttribute("burger") Burger burger, Model model, @PathVariable int id) {
        Burger burgerToEdit = burgerService.findBurger((long) id);
        model.addAttribute("burger", burgerToEdit);
        return "edit_burger.jsp";
    }

    @PostMapping("/updateburger/{id}")
    public String updateBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, @PathVariable int id) {
        if (result.hasErrors()) {
            return "edit_burger.jsp";
        } else {
            burgerService.updateBurger(burger);
            return "redirect:/";
        }
    }

}
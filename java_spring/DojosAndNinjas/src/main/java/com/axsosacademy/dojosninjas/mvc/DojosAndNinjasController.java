package com.axsosacademy.dojosninjas.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.axsosacademy.dojosninjas.mvc.models.Ninja;
import com.axsosacademy.dojosninjas.mvc.models.Dojo;
import com.axsosacademy.dojosninjas.mvc.repositories.NinjaRepository;
import com.axsosacademy.dojosninjas.mvc.services.NinjaService;
import com.axsosacademy.dojosninjas.mvc.services.DojoService;


import jakarta.validation.Valid;

@Controller
public class DojosAndNinjasController {
    @Autowired
    DojoService dojoService;

   @Autowired
   NinjaService ninjaService;

   @GetMapping("/add_ninja")
    public String ninja(Model model, @ModelAttribute("ninja") Ninja ninja){
        model.addAttribute("dojos",dojoService.getAll());
        return "ninja.jsp";
    }
   
 @PostMapping("/add_ninja")
    public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("dojos", dojoService.getAll());
            return "ninja.jsp";
        }

      ninjaService.create(ninja);
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(@ModelAttribute("dojo") Dojo dojo ,Model model){
    	model.addAttribute("dojos", dojoService.getAll());
        return "index.jsp";
    }
    
    @PostMapping("/add_dojo")
    public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo,BindingResult result,Model model){
	    if(result.hasErrors()){
	        return "index.jsp";
	    }
    
	    dojoService.addDojo(dojo);
	    return "redirect:/";
    }
	@GetMapping("/dojos/{id}")
	public String showNinjas(@PathVariable Long id , Model model){
	    Dojo dojo = dojoService.getDojoById(id);
	    model.addAttribute("dojo", dojo);
	
	    return "display.jsp";
	
	}
}
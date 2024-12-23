package com.axsosacademy.dojosninjas.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsosacademy.dojosninjas.mvc.models.Ninja;
import com.axsosacademy.dojosninjas.mvc.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	NinjaRepository ninjaRepository;
	public void addNinja(Ninja ninja){
	    ninjaRepository.save(ninja);
	}
	
	public List<Ninja> getAll(){
	    return ninjaRepository.findAll();
	
	}
	
	public void create(Ninja ninja){
	    ninjaRepository.save(ninja);
	}
}
package com.axsosacademy.dojosninjas.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsosacademy.dojosninjas.mvc.models.Dojo;
import com.axsosacademy.dojosninjas.mvc.repositories.DojoRepository;

@Service
public class DojoService {
    @Autowired
    DojoRepository dojoRepository;

    public void addDojo(Dojo dojo){
        dojoRepository.save(dojo);
    }
    
    public List<Dojo> getAll(){
        return dojoRepository.findAll();
    }
    
    public Dojo getDojoById(long id){
        Optional<Dojo> optionalDojo= dojoRepository.findById(id);
        if(optionalDojo.isPresent()){
            return optionalDojo.get();
        }
        return null;
    }
}
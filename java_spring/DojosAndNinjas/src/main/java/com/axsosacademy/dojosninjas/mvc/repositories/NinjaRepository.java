package com.axsosacademy.dojosninjas.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.dojosninjas.mvc.models.Ninja;
import com.axsosacademy.dojosninjas.mvc.models.Dojo;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long> {
    List<Ninja> findAll();
    Ninja findByDojo(Dojo dojo);
}
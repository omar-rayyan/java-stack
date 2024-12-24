package com.axsosacademy.dojosninjas.mvc.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="ninja")
public class Ninja {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    @NotNull(message = "Cannot be null")
	@Size(min=1,message = "Please enter the first name.")
    private String firstName;

    @NotNull(message = "Cannot be null")
    @Size(min=1,message = "Please enter the last name.")
    private String lastName;

    @NotNull(message = "Cannot be null")
    @Min(value=1,message = "Please enter a valid age.")
    private int age;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;

    public Ninja(){}
    
    public Ninja( String firstName, String lastName,int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age=age;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public Dojo getDojo() {
        return dojo;
    }
    
    public void setDojo(Dojo dojo) {
        this.dojo = dojo;
    }

}
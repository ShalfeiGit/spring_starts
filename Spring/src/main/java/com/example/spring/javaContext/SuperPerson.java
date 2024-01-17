package com.example.spring.javaContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("superPerson")
public class SuperPerson {
    private String name;
    private SuperCat cat;
    @Autowired
    public SuperPerson(@Value("${person.name}") String name, SuperCat cat) { // как использовать привязанные параметры в конструкторе ии методе ??
        this.name = name;
        this.cat = cat;
    }

    @Autowired
    public void setName(@Value("${person.name}")String name, SuperCat cat ) {
        this.name = name;
        this.cat = cat;
    }

    public String resetName(String firstName,  String defaultName ) {
        System.out.println("firstName: " + firstName);
        name = defaultName;
         int a = 10/0; // для отображения exception
        System.out.println("defaultName: " + defaultName);
        return name;
    }

    public String getName() {
        return name;
    }

    public void callPet(){
        System.out.println("Come on pet!");
        cat.say();
    }
}

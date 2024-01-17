package com.example.spring.introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;

@Scope("singleton")
public class Dog implements Pet {

    @PostConstruct
    public void init(){
        System.out.println("Dog init");
    }
    @PreDestroy
    public void destoy(){
        System.out.println("Dog destroy");
    }
    @Override
    public void  say () {
        System.out.println("Bow-wow");
    }
}

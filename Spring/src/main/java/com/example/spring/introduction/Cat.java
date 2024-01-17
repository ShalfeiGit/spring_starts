package com.example.spring.introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Cat implements Pet{
    @PostConstruct
    public void init(){
        System.out.println("Cat init");
    }
    @PreDestroy
    public void destoy(){
        System.out.println("Cat destroy");
    }
    @Override
    public void say() {
        System.out.println("Meow-meow");
    }
}

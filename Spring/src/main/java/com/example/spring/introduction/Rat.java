package com.example.spring.introduction;

import org.springframework.stereotype.Component;

@Component("rat")
public class Rat implements Pet {
    @Override
    public void say() {
        System.out.println("Pi-pi-pi");
    }

   public void sayHi(){
       System.out.println("No");
   }
}

package com.example.spring.javaContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


public class SuperCat {
    private String nickname;

    public SuperCat( String name) {
        this.nickname = name;
    }

//    @Autowired
    public void setNickname(String name) {
        this.nickname = name;
    }

    public String getNickname() {
        return nickname;
    }
    public void say() {
        System.out.println("Meow-meow");
    }
}

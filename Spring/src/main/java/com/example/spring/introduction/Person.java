package com.example.spring.introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Person {
    private Pet pet;
    private int age;
    private String surname;
    @Value("${person.name}")
    public String name;

    public void init() {
        System.out.println("Init person");
    }

    public void destroy() {
        System.out.println("Destroy person");
    }

    public void setSurname(String surname) {
        System.out.println("Set Surname");
        this.surname = surname;
    }

    public String getSurname() {
        System.out.println("Set age");
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Set age");
        this.age = age;
    }
    @Autowired
    public Person(@Qualifier("rat")Pet pet) {
        this.pet = pet;
    }
    public void callPet(){
        System.out.println("Come on pet!");
        pet.say();
    }
    @Autowired
    @Qualifier("rat")
    public void setPet(Pet pet) {
        System.out.println("Set pet");
        this.pet = pet;
    }

}

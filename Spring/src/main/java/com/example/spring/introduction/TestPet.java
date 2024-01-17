package com.example.spring.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPet {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); //подключение бинов из xml, перечисление через запятую
        Pet pet = context.getBean("cat", Pet.class);
        Pet pet2 = context.getBean("rat", Pet.class);
        Person person = new Person(pet);
        Person person1 = context.getBean("person", Person.class);
        Person person2 = context.getBean("person", Person.class);
        person.callPet();
        person1.callPet();
        System.out.println(person1.getAge());
        System.out.println(person1.getSurname());
        System.out.println(person1.name);
        context.close();
    }
}

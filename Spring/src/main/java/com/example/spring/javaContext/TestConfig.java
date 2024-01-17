package com.example.spring.javaContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(Context.class);
        SuperCat cat = context.getBean("superCat", SuperCat.class);
        System.out.println(cat.getNickname());
        SuperPerson person = context.getBean("superPerson", SuperPerson.class); // два способа создания java bean c помощью Bean и Component
        System.out.println(person.getName());
        person.callPet();
        person.setName("Mihail", cat);
        System.out.println(person.resetName("Valentin", "Victor"));
    }
}

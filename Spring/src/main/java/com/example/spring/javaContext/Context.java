package com.example.spring.javaContext;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.example.spring.javaContext")
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class Context {
    @Bean
    public SuperCat superCat (){
        return  new SuperCat("Vaska");
    }
}

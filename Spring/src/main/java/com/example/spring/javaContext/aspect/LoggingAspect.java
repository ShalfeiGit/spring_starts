package com.example.spring.javaContext.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    @Before("execution(public void callPet())")
    public void logAdvice() {
        System.out.println("log: Вызов домашнего животного человеком" );
    }
}

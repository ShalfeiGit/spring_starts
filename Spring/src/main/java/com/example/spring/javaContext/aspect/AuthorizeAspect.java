package com.example.spring.javaContext.aspect;

import com.example.spring.javaContext.SuperCat;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2) // порядок вызова
public class AuthorizeAspect {

    // @Before - выполняется до метода с основной логикой
    // @After returning - выполняется после нормального окончания метода с логикой
    // @After throwing - выполняется после выбрашенного исключения
    // @After - выполняется после окончания метода с логикой. Нет доступа к исключению и возврщаемому значению
    // @Around - выполняется до и после метода с основной логикой

    @Pointcut("execution(public * getName(..))") // ..- любое колличество параметров, *- замена любого параметра в execution
    public void getInfoPointcut(){}

    @Pointcut("execution(public String resetName(String, String))")
    public void resetNamePointcut(){}

    @Pointcut("execution(public * getNa*(..))") // ..- любое колличество параметров, *- замена любого параметра в execution
    public void getInfoPointcut2(){}

    @Pointcut("execution(public * com.example.spring.javaContext.SuperPerson.set*(..))")
    public void setInfoPointcut(){}

    @Pointcut("getInfoPointcut() || setInfoPointcut())")
    public void changeInfoAdvice(){}

    @Before("execution(public void callPet())")
    public void logAdvice2() {
        System.out.println("log: Вызов домашнего животного человеком 2" );
    }

    @Before("getInfoPointcut()")
    public void authorizeAdvice() {
        System.out.println("log: запрос имени пользователя" );
    }

    @Before("getInfoPointcut2()")
    public void authorizeAdvice2() {
        System.out.println("log: запрос имени пользователя - 2" );
    }

    @Before("setInfoPointcut()")
    public void updateInfoAdvice(JoinPoint joinPoint) { // получение в аспекте инфы о сигнатуре
        System.out.println("log: запрос установки смены параметров" );
        MethodSignature methodSignature = (MethodSignature ) joinPoint.getSignature();
        System.out.println("methodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod(): " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType(): " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName(): " + methodSignature.getReturnType());

        if(methodSignature.getName().equals("setName")){
            Object[] args = joinPoint.getArgs();
            for(Object a: args){
                if(a instanceof SuperCat){
                    SuperCat joinCat = (SuperCat) a;
                    System.out.println("joinCat.getNickname: " + joinCat.getNickname());
                }
                if(a instanceof String){
                    System.out.println("Person name: " + a);
                }
            }
        }


    }

    @Before("changeInfoAdvice()")
    public void checkInfoAdvice() {
        System.out.println("log: общее взаимодействие с информацией" );
    }

    @AfterReturning(pointcut = "resetNamePointcut()", returning = "defaultName")
    public String resetNameAdvice(String defaultName) {
        System.out.println("log: reset name detected " + defaultName);
        return defaultName;
    }

    @AfterThrowing(pointcut = "resetNamePointcut()", throwing = "exception")
    public void throwResetNameAdvice(Throwable exception) {
        System.out.println("log: exception reset= name detected " + exception);
    }

    @After("resetNamePointcut()")
    public void resetNameAdvice() {
        System.out.println("log: after reset name detected ");
    }

    @Around("resetNamePointcut()")
    public Object resetNameAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("log: START reset name");
        Object targetMethodResult;
        try{
            targetMethodResult  = proceedingJoinPoint.proceed(); // получение результата вызова метода
        }catch (Exception e ) {
            targetMethodResult = "ABRA CADABRA"; // изменяя значение - изменяем возращаемый результат метода
//            throw e; // чтобы в консли видеть ошибку
        }
        System.out.println("log: FINISH reset name");
        return  targetMethodResult;
    }

}

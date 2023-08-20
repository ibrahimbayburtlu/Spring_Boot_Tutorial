package com.ibrahimbayburtlu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


    // this is where we add all of our related advices for logging

    // let's start with a @Before Advice

    @Before("execution(public void addAccount())")
    public void beforeAddAccount(){

        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

    }
}

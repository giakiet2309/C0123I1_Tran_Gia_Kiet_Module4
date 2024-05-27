package com.example.thim4p2.configuration;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLoggingAspect {

    @Pointcut("execution(* com.example.thim4p2.controller.ComputerController.*(..))")
    public void controllerMethods() {}

    @AfterThrowing(pointcut = "controllerMethods()", throwing = "exception")
    public void logException(Exception exception) {
        // Log hoặc xử lý ngoại lệ theo nhu cầu
        System.out.println("Exception occurred: " + exception.getMessage());
    }
}

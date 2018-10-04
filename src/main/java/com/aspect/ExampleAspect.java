package com.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Log4j2
public class ExampleAspect {

    @Pointcut("@annotation(com.annotation.TrackTime)")
    public void annotated() {
    }

    @Before("annotated()")
    public void before() {
        System.out.println("Aspect1 Before");
    }

    @After("annotated()")
    public void after() {
        System.out.println("Aspect2 After");
    }

    @Around("annotated()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object value = null;
        try {
            value = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        long timeTaken = System.currentTimeMillis() - startTime;
        log.warn("Time Taken by {} is {}", joinPoint, timeTaken);
        System.out.println("Time Taken by " + joinPoint + " is " + timeTaken);
        System.out.println("Aspect3 Around");
        return value;
    }
}

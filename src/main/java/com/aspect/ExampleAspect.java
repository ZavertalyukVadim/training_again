package com.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
@Log
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
            log.warning(Arrays.toString(e.getStackTrace()));
        }

        long timeTaken = System.currentTimeMillis() - startTime;
        log.warning("Time Taken by " + joinPoint + " is " + timeTaken);
        System.out.println("Aspect3 Around");
        return value;
    }
}

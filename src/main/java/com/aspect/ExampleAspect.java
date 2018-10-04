package com.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ExampleAspect {

    @Pointcut("@annotation(com.annotation.TrackTime)")
    public void annotated() {}

    @Before("annotated()")
    public void before() {
        System.out.println("Aspect1");
    }

    @After("annotated()")
    public void after() {
        System.out.println("Aspect2");
    }
}

package com.toby.boot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ControllerLogAop {

    @Pointcut("execution(* com.toby.boot.controller.HelloController.hello())")
    public void startHelloLogging(){}

    @Before("startHelloLogging()")
    public void beforeHelloLogging(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info("================= method name = {} ======= ", signature.getMethod());
        log.info("================calculate start=====================");
    }

    @After("startHelloLogging()")
    public void afterHelloLoggin(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info("================ method name = {} ======", signature.getMethod());
        log.info("==============calculate end ==================");
    }
}

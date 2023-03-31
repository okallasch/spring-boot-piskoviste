package org.gopas.springbootdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Aspect
public class TimeTrackingAspect {

    // @Before -- JointPoint -- vytahnout jointPoint...getSignature

    @Around("@annotation(org.gopas.springbootdemo.annotations.TrackTime)")
    public Object trackTimeAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();
        System.out.println("Method " + joinPoint.getSignature().getName() + " started: " + start);
        Object obj = joinPoint.proceed();
        Instant end = Instant.now();
        System.out.println("Method " + joinPoint.getSignature().getName() + " end: " + end);
        return obj;
    }
}

package org.gopas.springbootdemo.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class CommonPointcutsConfig {

    @Pointcut("target(org.gopas.springbootdemo.rest.exceptionhandling.CustomRestExceptionHandler)")
    void exceptionHandlerExecutionLogging(){}

}

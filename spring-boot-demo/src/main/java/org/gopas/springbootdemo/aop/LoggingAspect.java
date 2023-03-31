package org.gopas.springbootdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.gopas.springbootdemo.rest.exceptionhandling.CustomRestExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(CustomRestExceptionHandler.class);

    @Before("org.gopas.springbootdemo.aop.CommonPointcutsConfig.exceptionHandlerExecutionLogging()")
    public void logExceptionsFromGlobalExceptionHandler(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        if (methodArgs.length > 0) {
            for (Object arg : methodArgs) {
                if (arg instanceof Throwable) {
                    logger.error(methodName, (Throwable) arg);
                }
            }
        }
    }

}

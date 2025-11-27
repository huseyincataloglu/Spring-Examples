package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());


    //@Before to make process before a method call
    //@After to make process after a method call
    //@AfterReturning to make process if the method returns successfully
    //@AfterThrowing
    @Around("execution(* org.example.service.CommentService.publishComment(..))") // to make process before and after the method call
    public void log(ProceedingJoinPoint joinPoint) { // ProceedingJoinPoint represents the intercepted method
        try {
            logger.info("Before: " + joinPoint.getSignature());

            joinPoint.proceed(); // methodu çalıştırır

            logger.info("After: " + joinPoint.getSignature());
        }
        catch (Throwable t ){
            logger.info(t.getMessage());
        }
    }




    @Around("execution(* org.example.service.CommentService.deleteComment(..))")
    public Object log2(ProceedingJoinPoint joinPoint){
        try {
            String methodname = joinPoint.getSignature().getName();
            Object[] args = joinPoint.getArgs();
            logger.info("Method: "+ methodname+" will be executed with " + Arrays.asList(args));
            Object returnBy = joinPoint.proceed();
            logger.info("Methods has been executed and returned " + returnBy);
            return returnBy;
        }
        catch (Throwable t){
            logger.info(t.getMessage());
            return "Ocurred exception :" + t.getMessage();
        }

    }


}

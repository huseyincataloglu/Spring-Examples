package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* org.example.service.CommentService.publishComment(..))")
    public void interceptedMethod(){};

    @Before("interceptedMethod()")
    public void beforeLogging(JoinPoint joinPoint){
        Object[] methodArguments = joinPoint.getArgs();
        String methodSignature = joinPoint.getSignature().getName();
        logger.info("Before call of " + methodSignature + " with arguments: " + Arrays.toString(methodArguments));
    }
    @After("interceptedMethod()")
    public void afterLogging(JoinPoint joinPoint){
        Object[] methodArguments = joinPoint.getArgs();
        String methodSignature = joinPoint.getSignature().getName();
        logger.info("Before call of " + methodSignature + " with arguments: " + Arrays.toString(methodArguments));
    }




    //@Before to make process before a method call
    //@After to make process after a method call
    //@AfterReturning to make process if the method returns successfully
    //@AfterThrowing
    @Around("firstPointCut()")
    public Object  log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Before: " + joinPoint.getSignature());
        Object result = joinPoint.proceed();
        logger.info("After: " + joinPoint.getSignature());
        return result;
    }
    

    @AfterThrowing(pointcut = "interceptedMethod()")
    public void LogException(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        logger.severe(() -> "❌ Exception thrown in method: " + methodName + "\n"
                + "Arguments: " + Arrays.toString(args) + "\n"
                + "Exception type: " + ex.getClass().getSimpleName() + "\n"
                + "Message: " + ex.getMessage() );


    }



//    @Around("execution(* org.example.service.CommentService.deleteComment(..))")
//    public Object log2(ProceedingJoinPoint joinPoint){
//        try {
//            String methodname = joinPoint.getSignature().getName();
//            Object[] args = joinPoint.getArgs();
//            logger.info("Method: "+ methodname+" will be executed with " + Arrays.asList(args));
//            Object returnBy = joinPoint.proceed();
//            logger.info("Methods has been executed and returned " + returnBy);
//            return returnBy;
//        }
//        catch (Throwable t){
//            logger.info(t.getMessage());
//            return "Ocurred exception :" + t.getMessage();
//        }
//
//    }



}

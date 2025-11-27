package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.model.Comment;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(2)
public class ValidationAspect {

    private final Logger logger = Logger.getLogger(ValidationAspect.class.getName());


    // USING CUSTOM ANNOTATION
    // But be careful with Around!
    // we have to delegate to the actual method because we have obtained this respornsibility
    @Around("@annotation(org.example.annotations.ToLog)")
    public Object validate(ProceedingJoinPoint joinPoint){ // ProceedingJoinPoint represents the intercepted method
        try {
            String methodname = joinPoint.getSignature().getName();  // We have obtained the intercepted method's name
            Object[] args = joinPoint.getArgs(); // and also its parameters
            Comment comment = (Comment) args[0];
            if(comment == null){
                logger.info("Method: "+ methodname+" will not be executed with " +
                        "Comment cannot be null");
                return "Method not executed ; comment cannot be null";
            }
            Object returnBy = joinPoint.proceed(); // we transmitted the work flow to the actual method within the COmmentService
            // proceed worked the actual method and returned its returned value within Object type
            logger.info("Methods has been executed and returned " + returnBy);
            return returnBy; // we have also return the actual method return value
        }
        catch (Throwable t){
            logger.info(t.getMessage());
            return "Ocurred exception :" + t.getMessage();
        }

    }
}



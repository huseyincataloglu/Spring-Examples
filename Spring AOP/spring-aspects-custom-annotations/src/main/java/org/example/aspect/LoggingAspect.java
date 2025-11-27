package org.example.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(1)
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());


    //@Before to make process before a method call
    //@After to make process after a method call
    //@AfterReturning to make process if the method returns successfully
    //@AfterThrowing
//    @Before("execution(* org.example.service.CommentService.publishComment(..))") // to make process before the actual method call
//    public void logBefore(JoinPoint joinPoint) { // JoinPoint represents the intercepted method
//
//        logger.info("Before: " + joinPoint.getSignature());
//
//    }

//    @Before("@annotation(org.example.annotations.ToLog)")
//    public void logBefore(JoinPoint joinPoint) { // JoinPoint represents the intercepted method
//
//        logger.info("Before: " + joinPoint.getSignature());
//    }
//
//    // AfterReturning assumess this method will be returned successfullu
//    @AfterReturning(value = "@annotation(org.example.annotations.ToLog)",returning = "returnedValue")
//    public void logAfter(Object returnedValue){
//        logger.info("Method executed and returnd : ".formatted(returnedValue));
//    }

    @Around(value = "@annotation(org.example.annotations.ToLog) ")
    public Object log (ProceedingJoinPoint joinPoint) throws Throwable
    {
        logger.info("Logging Aspect: Calling the intercepted method");
        Object returnedValue = joinPoint.proceed();
        logger.info("Logging Aspect: "+returnedValue);
        return returnedValue;
    }

    /*
     @Before, @After, @AfterReturning, @Around Karşılaştırması
    1. @Before
    Hedef metottan önce çalışır.

    proceed() falan yoktur çünkü metodu sen kontrol etmezsin.

    Hedef metot her halükârda çalışır.

⚠️ Yani çalışsın mı çalışmasın mı diyemezsin.

    2. @After
    Hedef metot çalıştıktan her durumda (başarı veya hata) çalışır.

    Return değeriyle ilgilenmez.

    Hedef metodu kontrol edemezsin.

    3. @AfterReturning(returning = "val")
    Metot başarıyla dönerse çalışır.

    Dönüş değeri val parametresi ile alınır.

    Ama yine hedef metodu sen çalıştırmazsın.

    4. @Around
    En güçlüsü. Metodu keser, ister çalıştırır, ister durdurur.

    proceed() ile çalıştırma kontrolü senin elinde.

    Hem girişte, hem çıkışta müdahale edebilirsin.

    Dönüş değerini değiştirebilir, istiyorsan istisna fırlatabilirsin.


     */



}

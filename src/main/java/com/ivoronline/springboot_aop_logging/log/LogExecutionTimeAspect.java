package com.ivoronline.springboot_aop_logging.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeAspect {

  @Around("@annotation(LogExecutionTime)")
  public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

    //EXECUTE BEFORE METHOD
    long start = System.currentTimeMillis();

    //EXECUTE METHOD
    Object proceed = joinPoint.proceed();

    //EXECUTE AFTER METHOD
    long executionTime = System.currentTimeMillis() - start;
    System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");

    //RETURN METHOD RESULT
    return proceed;

  }

}
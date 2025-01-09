package com.babustore.www.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {
	
	private static final Logger logger=LoggerFactory.getLogger(AspectConfig.class);
	@Before("execution(* com.babustore.www.service.*.*(..))")
	 public void logBefore(JoinPoint joinPoint) {
        logger.info("Method {} is about to execute. Args: {}", 
                     joinPoint.getSignature(), 
                     joinPoint.getArgs());
    }
	@AfterReturning(pointcut = "execution(* com.babustore.www.service.*.*(..))",returning = "result")
	public void logAfterReturning(JoinPoint joinPoint,Object result) {
		logger.info("Method{} executes sucessfully.returning{}",joinPoint.getSignature(),result);
	}
	@AfterThrowing(pointcut = "execution(* com.babustore.www.service.*.*(..))",throwing = "exception")
	public void logAfterThrow(JoinPoint joinPoint,Throwable exception) {
		logger.info("Method {} threw exception:{}",joinPoint.getSignature(),exception.getMessage());
	}
	
	
	
}

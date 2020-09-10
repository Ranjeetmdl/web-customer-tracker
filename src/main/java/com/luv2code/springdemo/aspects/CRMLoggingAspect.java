package com.luv2code.springdemo.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	//setup pointcut declaration
	@Pointcut("execution(* com.luv2code.springdemo.controllers.*.*(..))")
	private void forControllerPackage(){}
	
	@Pointcut("execution(* com.luv2code.springdemo.services.*.*(..))")
	private void forServicePackage(){}
	
	@Pointcut("execution(* com.luv2code.springdemo.daos.*.*(..))")
	private void forDaoPackage(){}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow(){}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint){
		//display the method, we are advising on
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("==>in @Before advice-calling method :"+theMethod);
		
		//display the method arguments
		Object[] args = theJoinPoint.getArgs();
		for(Object arg : args){
			myLogger.info("===> Argument :"+arg);
		}
	}
	
	//add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()",
			returning="theResults")
	public void afterReturning(JoinPoint theJoinPoint, Object theResults){
		//display the method, we are advising on
		String theMethod = theJoinPoint.getSignature().toShortString();
	    myLogger.info("==>in @AfterReturning advice-from method :"+theMethod);
	    
	    //display the returned result
	    
	    myLogger.info("====> Results :"+theResults);
		
	}
}

package com.cognizant.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;



@Aspect
public class LoggingAspect {
	private static final Logger logger = Logger.getLogger(LoggingAspect.class);
	
	@Before("execution(public void updateTransactionDetails(..))")
	public void loggingAdvice(){
		logger.info("befor logginAdvice");
	}
	
	@After("execution(public void updateTransactionDetails(..))")
	public void loggingAdviceAfter(){
		logger.info("after logginAdvice");
	}
}

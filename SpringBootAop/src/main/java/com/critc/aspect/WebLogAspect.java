package com.critc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 *  在切入点前的操作，按order的值由小到大执行
	在切入点后的操作，按order的值由大到小执行
 * @author liuzr
 *
 */
@Aspect
@Component
public class WebLogAspect {
	Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
	
	ThreadLocal<Long> startTime = new ThreadLocal<>();
	
	@Pointcut("execution(public * com.critc.controller..*.*(..))")
	public void webLog(){}
	
	
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint){
		startTime.set(System.currentTimeMillis());
	}
	
	
	@AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
        logger.info("RESPONSE :ss " + ret);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
        startTime.remove();

    }
	
	
	
}

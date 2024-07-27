package com.sist.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
	
	
	@Around("execution(* com.sist..*(.. ))")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
		/*
		 *  AOP 동작원리 
		 *  Controller = > service 의존하고있는 상태에서
		 *  스프링 빈에 지정된 service가 컨테이너에 등록이 될때
		 *  진짜 서비스가아닌 가짜서비스를 앞에 세운다
		 *  가짜 서비스가 끝나면 joinPoint.proceed를 하게되면 진짜 서비스를 호출(프록시)
		 * 
		 * 
		 */
		long start= System.currentTimeMillis();
		System.out.println("START:"+joinPoint.toString());
		try {
			Object result=joinPoint.proceed();
			return joinPoint.proceed();
		} finally {
			long finish=System.currentTimeMillis();
			long timeMs =finish-start;
			System.out.println("END="+joinPoint.toString()+" "+timeMs+"ms");
		}
			
		}
}

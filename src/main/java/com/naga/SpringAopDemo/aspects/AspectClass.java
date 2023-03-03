package com.naga.SpringAopDemo.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass
{
	@Before("funMethod() && allmethodsOfCar()")
	public void loggerAdvice()
	{
		System.out.println("ready to execute fun method.");
	}
	
	@Pointcut("execution(* com.naga.SpringAopDemo.model.Car.fun(..))")
	public void funMethod() {};
	
	@Pointcut("within(com.naga.SpringAopDemo.model.Car)")
	public void allmethodsOfCar() {};
	
	
	@Before("funMethod()")
	public void loggerAdviceBeforeMethodExecution(JoinPoint joinpoint)
	{
		System.out.println("Fun belongs to:"+joinpoint.getTarget().getClass().getName());
		//System.out.println("Fun belongs to:"+joinpoint.getSignature().getClass().getName());Not getting the requied class name.
	}
	
	@AfterReturning(pointcut="funMethod()")
	public void afterFunSuccess()
	{
		System.out.println("FUn executed successfully.");
	}
	
	@AfterThrowing(pointcut="funMethod()", throwing="ex")
	public void afterFunFailure(Exception ex)
	{
		System.out.println("fun Interrupted with an exception: "+ex);
	}
	
	//Around's two advantages:1)before&after in single method.
		//					  2)taking the control and hence ability to change the parameter's values.
	@Around("execution(public String getName())")
	public String setMethod(ProceedingJoinPoint proceedingJoinPoint)
	{
		String returnValue=null;
		try
		{
			//Before()
			System.out.println("ready to execute getNameMethod of car class.");
			returnValue=(String)proceedingJoinPoint.proceed(); //to execute setName() of Car.
			//AfterReturning()
			System.out.println("getName Executed successfully.");
		}
		catch (Throwable e)
		{
			// TODO Auto-generated catch block
			System.out.println("exception occured at getName: "+e);
		}
		return returnValue;
	}
	
	@Around("@annotation(com.naga.SpringAopDemo.aspects.Log)")
	public void AllSetMethods(ProceedingJoinPoint proceedingJoinPoint)
	{
		try
		{
			//Before()
			System.out.println("ready to execute...."+proceedingJoinPoint.getSignature().getName());
			proceedingJoinPoint.proceed(); //to execute setName() of Car.
			//AfterReturning()
			System.out.println("Executed successfully.."+proceedingJoinPoint.getSignature().getName());
		}
		catch (Throwable e)
		{
			// TODO Auto-generated catch block
			System.out.println("exception occured "+e);
		}
	}
}

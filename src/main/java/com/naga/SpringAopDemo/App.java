package com.naga.SpringAopDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.naga.SpringAopDemo.config.AppConfig;
import com.naga.SpringAopDemo.model.Car;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        @SuppressWarnings("resource")
        //ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		ApplicationContext context=new ClassPathXmlApplicationContext("springBeans.xml");//xml configuration
		Car car=context.getBean("car",com.naga.SpringAopDemo.model.Car.class);
		car.fun();
		car.setName("OODI");
		car.setId(5467);
		System.out.println("car name is: "+car.getName()+" and id is:"+car.getId());
    }
}

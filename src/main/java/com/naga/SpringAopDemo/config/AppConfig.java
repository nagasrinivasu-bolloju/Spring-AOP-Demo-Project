package com.naga.SpringAopDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.naga")
@EnableAspectJAutoProxy
public class AppConfig
{
//	@Bean
//	public AspectClass bean()
//	{
//		return new AspectClass();
//	}
}

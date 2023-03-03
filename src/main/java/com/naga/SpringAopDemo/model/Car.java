package com.naga.SpringAopDemo.model;

import org.springframework.stereotype.Component;

import com.naga.SpringAopDemo.aspects.Log;

@Component
public class Car
{
	private String name;
	private int id;
	public void fun()
	{
		System.out.println("Inside car...");
		throw new RuntimeException();
	}
	public String getName() {
		return name;
	}
	@Log
	public void setName(String name) {
		if(name=="BMW")
			throw new RuntimeException();
		this.name = name;
		
	}
	public int getId() {
		return id;
	}
	@Log
	public void setId(int id) {
		this.id = id;
	}
	
}

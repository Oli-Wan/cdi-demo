package oschneider.cdi.demo.controller;

import javax.annotation.PostConstruct;

import oschneider.cdi.demo.qualifier.stereotype.Demo;



@Demo
public class SterotypeController
{
	private String hello;

	@PostConstruct
	public void init()
	{
		hello = "Sterotyped hello!";
	}

	public String getHello()
	{
		return hello;
	}

	public void setHello( String hello )
	{
		this.hello = hello;
	}

}

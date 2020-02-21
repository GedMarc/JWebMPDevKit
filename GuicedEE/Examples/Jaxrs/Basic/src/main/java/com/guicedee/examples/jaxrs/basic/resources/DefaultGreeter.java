package com.guicedee.examples.jaxrs.basic.resources;

public class DefaultGreeter implements Greeter
{
	public String greet(final String name)
	{
		return "Hello " + name;
	}
}

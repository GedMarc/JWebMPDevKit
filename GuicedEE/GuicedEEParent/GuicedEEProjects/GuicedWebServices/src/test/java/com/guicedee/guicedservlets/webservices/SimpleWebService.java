package com.guicedee.guicedservlets.webservices;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(name = "SimpleWebService")
public class SimpleWebService
{

	public static void main(String args[])
	{
		Endpoint.publish("http://localhost:6006/SimpleWebService", new SimpleWebService());
	}

	public String sayHello(String name)
	{
		return "Hello, " + name + "!";
	}

}

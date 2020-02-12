package com.guicedee.guicedservlets.webservices;

import io.undertow.Undertow;
import com.guicedee.logger.LogFactory;
import com.guicedee.guicedservlets.undertow.GuicedUndertow;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

class WSTest
{
	public static void main(String[] args) throws Exception
	{
		LogFactory.configureConsoleColourOutput(Level.FINE);
		LogFactory.setGroupLevel("com.sun.xml.bind",Level.INFO);
		GuicedUndertow.boot("localhost", 6004);
	}

	@Test
	void testMe() throws Exception
	{
		LogFactory.configureConsoleColourOutput(Level.FINE);
		LogFactory.setGroupLevel("com.sun.xml.bind",Level.INFO);
		LogFactory.setGroupLevel("javax.xml.bind",Level.INFO);
		Undertow ud = GuicedUndertow.boot("localhost", 6004);
		System.out.println("Started Server");



		ud.stop();
	}
}

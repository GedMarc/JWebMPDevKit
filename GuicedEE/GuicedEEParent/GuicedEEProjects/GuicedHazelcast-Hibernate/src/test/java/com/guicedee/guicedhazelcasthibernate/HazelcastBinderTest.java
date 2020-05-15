package com.guicedee.guicedhazelcasthibernate;

import com.guicedee.guicedhazelcast.HazelcastProperties;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.logger.LogFactory;
import com.guicedee.logger.logging.LogColourFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CacheResult;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

public class HazelcastBinderTest
{

	private HazelcastBinderTest test;

	private String returnTest = "Not this one";

	@Test
	public void testCaching()
	{
		LogFactory.configureConsoleColourOutput(Level.FINE);
		LogColourFormatter.setRenderBlack(false);

		HazelcastProperties.setStartLocal(true);

		HazelcastBinderTest c = GuiceContext.get(HazelcastBinderTest.class);
		test = c;
		System.out.println(test.test("1"));
		System.out.println(test.test("2"));
		System.out.println(test.test("Cache Test"));

		test.returnTest = "Test the Cache Pull";

		String result = test.test("Cache Test");
		System.out.println("Output from cache : " + test.test("Cache Test"));
		System.out.println("Output from result : " + test.test("Cache Test"));

		assertEquals("Not this one", test.test("Cache Test"));

		String shouldBeCached = test.test("Cache Test");

		if (shouldBeCached
				    .equals(test.returnTest))
		{
			Assertions.fail("Cache is not being hit");
		}
		else
		{

		}
	}

	@CacheResult
	public String test(@CacheKey String key)
	{
		switch (key)
		{
			case "1":
				return "One";
			case "2":
				return "Two";
			default:
				return returnTest;
		}
	}
}


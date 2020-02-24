package com.guicedee.examples.jaxrs.basic;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.rest.RESTContext;
import com.guicedee.guicedservlets.undertow.GuicedUndertow;
import io.undertow.Undertow;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BootJaxRSBasic
{
	public static void main(String... args) throws Exception
	{
		RESTContext.getProviders()
		           .add(JacksonJsonProvider.class.getCanonicalName());
		GuiceContext.instance()
		            .getConfig()
		            .setExcludeModulesAndJars(true);
		Undertow undertow = GuicedUndertow.boot("0.0.0.0", 6003);
		//It is deployed

		//Do stuff
		HttpClient client = HttpClient.newBuilder()
		                              .connectTimeout(Duration.of(5, ChronoUnit.SECONDS))
		                              .build();
		HttpResponse response = client.send(HttpRequest.newBuilder()
		                                               .GET()
		                                               .uri(new URI("http://localhost:6003/rest/hello/world"))
		                                               .build(),
		                                    HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());
		response = client.send(HttpRequest.newBuilder()
		                                  .GET()
		                                  .uri(new URI("http://localhost:6003/rest/hello/helloObject/world"))
		                                  .build(),
		                       HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		undertow.stop();
		System.exit(0);
	}
}

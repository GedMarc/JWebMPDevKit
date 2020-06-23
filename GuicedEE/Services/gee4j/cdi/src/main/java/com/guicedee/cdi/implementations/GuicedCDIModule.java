package com.guicedee.cdi.implementations;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import com.guicedee.cdi.services.NamedBindings;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.MethodInfo;

import javax.annotation.PostConstruct;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.lang.reflect.Method;

import static com.guicedee.guicedinjection.json.StaticStrings.*;
import static java.lang.String.*;

public class GuicedCDIModule
		extends AbstractModule
		implements IGuiceModule<GuicedCDIModule>, TypeListener
{
	@Override
	protected void configure()
	{
		super.configure();
		bindListener(Matchers.any(), this);

		for (ClassInfo classInfo : GuiceContext.instance()
		                                       .getScanResult()
		                                       .getClassesWithAnnotation(ApplicationScoped.class.getCanonicalName()))
		{
			if (classInfo.isInterfaceOrAnnotation()
			    || classInfo.hasAnnotation("javax.enterprise.context.Dependent"))
			{
				continue;
			}
			Class<?> clazz = classInfo.loadClass();
			String name = NamedBindings.cleanName(classInfo, STRING_EMPTY);
			NamedBindings.bindToScope(binder(), clazz, name, Singleton.class);
		}

		for (ClassInfo classInfo : GuiceContext.instance()
		                                       .getScanResult()
		                                       .getClassesWithAnnotation(RequestScoped.class.getCanonicalName()))
		{
			if (classInfo.isInterfaceOrAnnotation()
			    || classInfo.hasAnnotation("javax.enterprise.context.Dependent"))
			{
				continue;
			}
			Class<?> clazz = classInfo.loadClass();
			String name = NamedBindings.cleanName(classInfo, STRING_EMPTY);
			NamedBindings.bindToScope(binder(), clazz, name, com.google.inject.servlet.RequestScoped.class);
		}

		for (ClassInfo classInfo : GuiceContext.instance()
		                                       .getScanResult()
		                                       .getClassesWithAnnotation(SessionScoped.class.getCanonicalName()))
		{
			if (classInfo.isInterfaceOrAnnotation()
			    || classInfo.hasAnnotation("javax.enterprise.context.Dependent"))
			{
				continue;
			}
			Class<?> clazz = classInfo.loadClass();
			String name = NamedBindings.cleanName(classInfo, STRING_EMPTY);
			NamedBindings.bindToScope(binder(), clazz, name, com.google.inject.servlet.SessionScoped.class);
		}

		for (ClassInfo classInfo : GuiceContext.instance()
		                                       .getScanResult()
		                                       .getClassesWithAnnotation(Named.class.getCanonicalName()))
		{
			if (classInfo.isInterfaceOrAnnotation()
			    || classInfo.hasAnnotation("javax.enterprise.context.Dependent"))
			{
				continue;
			}
			Class<?> clazz = classInfo.loadClass();
			String name = NamedBindings.cleanName(classInfo, STRING_EMPTY);
			NamedBindings.bindToScope(binder(), clazz, name);
		}
	}

	@Override
	public Integer sortOrder()
	{
		//Let faces bind converters and things first
		return 151;
	}

	/**
	 * Call postconstruct method (if annotation exists).
	 */
	@Override
	public <I> void hear(final TypeLiteral<I> type, final TypeEncounter<I> encounter)
	{
		encounter.register((InjectionListener<I>) injectee ->
		{
			Class<?> clazz = injectee.getClass();
			for (Method methodInfo : clazz.getDeclaredMethods())
			{
				if (methodInfo.isAnnotationPresent(PostConstruct.class))
				{
					try
					{
						methodInfo.invoke(injectee);
					}
					catch (final IllegalAccessException e)
					{
						System.out.println("Could not fire PostConstruct - Module does not expose class with a CDI annotation - " + clazz.getCanonicalName());
					}
					catch (final Exception e)
					{
						throw new RuntimeException(format("@PostConstruct %s", methodInfo), e);
					}
				}
			}
		});
	}
}

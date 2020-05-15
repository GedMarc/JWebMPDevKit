package com.guicedee.guicedhazelcasthibernate;

import com.google.inject.persist.UnitOfWork;
import com.guicedee.guicedhazelcast.HazelcastProperties;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedpersistence.btm.implementation.BTMAutomatedTransactionHandler;
import com.guicedee.logger.LogFactory;
import com.guicedee.logger.logging.LogColourFormatter;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.logging.Level;

public class GuicedPersistenceBindingTest
{
	@Test
	public void testMe() throws InterruptedException
	{
		LogFactory.configureConsoleSingleLineOutput(Level.FINE);
		LogColourFormatter.setRenderBlack(false);

		HazelcastProperties.setStartLocal(true);

		GuiceContext.inject();

		UnitOfWork uw = GuiceContext.get(UnitOfWork.class, TestCustomPersistenceLoader.class);
		EntityManager em = GuiceContext.get(EntityManager.class, TestCustomPersistenceLoader.class);
		System.out.println("open : " + em.isOpen());

		BTMAutomatedTransactionHandler.setActive(true);
	}
}

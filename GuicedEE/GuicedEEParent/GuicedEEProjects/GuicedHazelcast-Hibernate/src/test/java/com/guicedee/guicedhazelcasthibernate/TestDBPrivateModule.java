package com.guicedee.guicedhazelcasthibernate;

import com.guicedee.guicedpersistence.btm.BTMConnectionBaseInfo;
import com.guicedee.guicedpersistence.db.ConnectionBaseInfo;
import com.guicedee.guicedpersistence.db.DatabaseModule;
import com.oracle.jaxb21.PersistenceUnit;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.util.Properties;

public class TestDBPrivateModule
		extends DatabaseModule<TestDBPrivateModule>
{

	@NotNull
	@Override
	protected String getPersistenceUnitName()
	{
		return "guiceinjectionh2test";
	}

	@Override
	protected @NotNull ConnectionBaseInfo getConnectionBaseInfo(PersistenceUnit unit, Properties filteredProperties)
	{
		return new BTMConnectionBaseInfo();
	}

	@NotNull
	@Override
	protected String getJndiMapping()
	{
		return "jdbc/jndi";
	}

	@NotNull
	@Override
	protected Class<? extends Annotation> getBindingAnnotation()
	{
		return TestCustomPersistenceLoader.class;
	}
}

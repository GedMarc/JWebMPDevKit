module org.hibernate.validator {
	requires java.validation;
	requires org.jboss.logging;
	requires java.xml;
	requires com.fasterxml.classmate;
	requires java.persistence;
	requires java.scripting;
	requires javax.el;
	requires java.desktop;
	requires java.compiler;

	exports org.hibernate.validator;

	exports org.hibernate.validator.spi.cfg;
	exports org.hibernate.validator.spi.group;
	exports org.hibernate.validator.spi.resourceloading;
	exports org.hibernate.validator.spi.scripting;
	exports org.hibernate.validator.cfg;
	exports org.hibernate.validator.cfg.context;
	exports org.hibernate.validator.cfg.defs;
	exports org.hibernate.validator.cfg.defs.br;
	exports org.hibernate.validator.cfg.defs.pl;
	exports org.hibernate.validator.engine;
	exports org.hibernate.validator.constraints;
	exports org.hibernate.validator.constraints.br;
	exports org.hibernate.validator.constraints.pl;
	exports org.hibernate.validator.constraints.time;
	exports org.hibernate.validator.constraintvalidation;
	exports org.hibernate.validator.constraintvalidators;
	exports org.hibernate.validator.group;
	exports org.hibernate.validator.messageinterpolation;
	exports org.hibernate.validator.parameternameprovider;
	exports org.hibernate.validator.path;
	exports org.hibernate.validator.resourceloading;

	uses org.hibernate.validator.spi.cfg.ConstraintMappingContributor;
	uses org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;
	uses org.hibernate.validator.spi.resourceloading.ResourceBundleLocator;
	uses org.hibernate.validator.spi.scripting.ScriptEvaluator;
	uses org.hibernate.validator.spi.scripting.ScriptEvaluatorFactory;

	provides javax.validation.spi.ValidationProvider with org.hibernate.validator.HibernateValidator;

}

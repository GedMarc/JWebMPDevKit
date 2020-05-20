module org.hibernate.orm.jpamodelgen {

	requires static java.compiler;
	requires java.xml;
	requires java.sql;
	requires java.xml.bind;

	requires static java.desktop;

	provides javax.annotation.processing.Processor with org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor;
}

module javax.ejb {
	requires java.rmi;
	requires java.transaction;
	requires java.xml;
	requires javax.servlet.api;
	requires java.naming;
	exports javax.ejb;
	exports javax.ejb.embeddable;
	exports javax.ejb.spi;

	uses  javax.ejb.spi.EJBContainerProvider;
	uses javax.ejb.EJBContext;
}
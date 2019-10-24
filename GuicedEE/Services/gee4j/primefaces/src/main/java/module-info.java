open module primefaces {

	//requires javax.faces;
	requires org.apache.commons.io;
	requires org.apache.commons.fileupload;
	requires javax.servlet.api;
	requires javax.el;
	requires java.validation;

	//requires static com.hazelcast.all;
	requires java.sql;
	requires java.scripting;
	requires static java.desktop;
//	requires org.apache.poi;
//	requires org.apache.poi.ooxml;


	requires static itext;
	//requires java.xml.bind;
	requires static barcode4j.light;
	requires static rome;
//	requires org.apache.xmlbeans;
	requires static encoder;
	requires static owasp.java.html.sanitizer;
	requires static esapi;

	requires org.apache.commons.lang3;

}
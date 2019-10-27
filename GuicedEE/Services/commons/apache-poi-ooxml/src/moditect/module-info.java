module org.apache.poi.ooxml {
	requires org.apache.poi;
	requires static org.apache.xmlbeans;

	requires static poi.ooxml.schemas;
	requires static java.desktop;
	requires org.apache.commons.collections4;

	opens schemaorg_apache_xmlbeans.system.sD023D6490046BA0250A839A9AD24C443 to org.apache.xmlbeans;

	exports org.apache.poi.ooxml;
	exports org.apache.poi.ooxml.util;
	exports org.apache.poi.ooxml.dev;
	exports org.apache.poi.ooxml.extractor;
	exports org.apache.poi.openxml4j.util;
	exports org.apache.poi.openxml4j.exceptions;
	exports org.apache.poi.openxml4j.opc;
	exports org.apache.poi.openxml4j.opc.internal;
	exports org.apache.poi.openxml4j.opc.internal.marshallers;
	exports org.apache.poi.openxml4j.opc.internal.unmarshallers;
	exports org.apache.poi.poifs.crypt.agile;
	exports org.apache.poi.poifs.crypt.dsig;
	exports org.apache.poi.poifs.crypt.dsig.facets;
	exports org.apache.poi.poifs.crypt.dsig.services;
	exports org.apache.poi.poifs.crypt.temp;
	exports org.apache.poi.xddf.usermodel;
	exports org.apache.poi.xddf.usermodel.chart;
	exports org.apache.poi.xddf.usermodel.text;
	exports org.apache.poi.xdgf.util;
	exports org.apache.poi.xdgf.exceptions;
	exports org.apache.poi.xdgf.extractor;
	exports org.apache.poi.xdgf.usermodel;
	exports org.apache.poi.xdgf.usermodel.section;
	exports org.apache.poi.xdgf.usermodel.section.geometry;
	exports org.apache.poi.xdgf.usermodel.shape;
	exports org.apache.poi.xdgf.usermodel.shape.exceptions;
	exports org.apache.poi.xdgf.xml;
	exports org.apache.poi.xslf.util;
	exports org.apache.poi.xslf.draw;
	exports org.apache.poi.xslf.extractor;
	exports org.apache.poi.xslf.model;
	exports org.apache.poi.xslf.usermodel;


	exports org.apache.poi.xssf;
	exports org.apache.poi.xssf.util;
	exports org.apache.poi.xssf.binary;
	exports org.apache.poi.xssf.eventusermodel;
	exports org.apache.poi.xssf.extractor;
	exports org.apache.poi.xssf.model;
	exports org.apache.poi.xssf.streaming;
	exports org.apache.poi.xssf.usermodel;
	exports org.apache.poi.xssf.usermodel.charts;
	exports org.apache.poi.xssf.usermodel.extensions;
	exports org.apache.poi.xssf.usermodel.helpers;
	exports org.apache.poi.xwpf.extractor;
	exports org.apache.poi.xwpf.model;
	exports org.apache.poi.xwpf.usermodel;

	requires org.apache.commons.compress;

}
open module javax.servlet.jsp.jstl {
	requires transitive javax.servlet.jsp;
	requires java.xml;
	requires static java.sql;

	requires java.desktop;
	requires java.naming;
	requires jdk.xml.dom;

	exports javax.servlet.jsp.jstl.core;
	exports javax.servlet.jsp.jstl.fmt;
	exports javax.servlet.jsp.jstl.sql;
	exports javax.servlet.jsp.jstl.tlv;

	exports org.apache.taglibs.standard;
	exports org.apache.taglibs.standard.extra.spath;
	exports org.apache.taglibs.standard.functions;
	exports org.apache.taglibs.standard.lang.jstl;
	exports org.apache.taglibs.standard.lang.jstl.parser;
	exports org.apache.taglibs.standard.lang.jstl.test;
	exports org.apache.taglibs.standard.lang.jstl.test.beans;
	exports org.apache.taglibs.standard.lang.support;
	exports org.apache.taglibs.standard.resources;
	exports org.apache.taglibs.standard.tag.common.core;
	exports org.apache.taglibs.standard.tag.common.fmt;
	exports org.apache.taglibs.standard.tag.common.sql;
	exports org.apache.taglibs.standard.tag.common.xml;
	exports org.apache.taglibs.standard.tag.el.core;
	exports org.apache.taglibs.standard.tag.el.fmt;
	exports org.apache.taglibs.standard.tag.el.sql;
	exports org.apache.taglibs.standard.tag.el.xml;
	exports org.apache.taglibs.standard.tag.rt.core;
	exports org.apache.taglibs.standard.tag.rt.fmt;
	exports org.apache.taglibs.standard.tag.rt.sql;
	exports org.apache.taglibs.standard.tag.rt.xml;
	exports org.apache.taglibs.standard.tei;
	exports org.apache.taglibs.standard.tlv;
}

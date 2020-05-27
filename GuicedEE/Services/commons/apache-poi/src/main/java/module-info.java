module org.apache.poi {
	requires static java.desktop;
	requires transitive java.xml.bind;
	requires org.apache.commons.math3;
	requires org.apache.commons.codec;
	requires org.apache.commons.collections4;

	requires org.apache.commons.logging;
}

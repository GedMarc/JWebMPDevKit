module org.apache.poi {
	requires static java.desktop;
	requires java.xml.bind;
	requires static org.apache.commons.math3;
	requires static org.apache.commons.codec;
	requires static org.apache.commons.collections4;
	requires java.logging;

	requires org.apache.commons.logging;

	exports org.apache.poi.hssf.usermodel;
	exports org.apache.poi.ss.usermodel;
	exports org.apache.poi.ss.formula;

	exports org.apache.poi to org.apache.poi.ooxml;
	exports org.apache.poi.common.usermodel to org.apache.poi.ooxml;
	exports org.apache.poi.common.usermodel.fonts to org.apache.poi.ooxml;
	exports org.apache.poi.util to org.apache.poi.ooxml;
	exports org.apache.poi.poifs.filesystem to org.apache.poi.ooxml;
	exports org.apache.poi.ss to org.apache.poi.ooxml;
	exports org.apache.poi.ss.util to org.apache.poi.ooxml;
	exports org.apache.poi.ss.formula.udf to org.apache.poi.ooxml;
	exports org.apache.poi.ss.usermodel.charts to org.apache.poi.ooxml;
}

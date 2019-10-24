module org.apache.commons.fileupload {
	exports org.apache.commons.fileupload;
	exports org.apache.commons.fileupload.disk;
	exports org.apache.commons.fileupload.servlet;

	requires static portlet.api;

	requires static javax.servlet.api;


	requires org.apache.commons.io;

}

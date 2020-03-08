module org.apache.commons.fileupload {
	exports org.apache.commons.fileupload;
	exports org.apache.commons.fileupload.disk;
	exports org.apache.commons.fileupload.servlet;


	requires static javax.servlet.api;

	requires transitive org.apache.commons.io;

}

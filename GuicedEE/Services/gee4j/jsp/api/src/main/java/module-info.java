module javax.servlet.jsp.api {
	requires javax.el;
	requires javax.servlet.api;
	requires static java.desktop;

	exports javax.servlet.jsp;
	exports javax.servlet.jsp.el;
	exports javax.servlet.jsp.tagext;
}

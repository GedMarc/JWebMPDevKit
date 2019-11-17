module com.fasterxml.jackson.jaxrs.json {

	//CXF, RESTEasy, and OpenAPI require reflective access
	opens com.fasterxml.jackson.jaxrs.json;

    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.module.jaxb;

    requires com.fasterxml.jackson.jaxrs.base;

    requires static java.ws.rs;

    exports com.fasterxml.jackson.jaxrs.json.annotation;

    provides javax.ws.rs.ext.MessageBodyReader with
        com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
    provides javax.ws.rs.ext.MessageBodyWriter with
        com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
}

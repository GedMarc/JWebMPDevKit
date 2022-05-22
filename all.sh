cd Guiced-EE/BOM/Versioner/
mvn clean source:jar javadoc:jar install -P jdk9
cd ..
cd ..
cd ..
mvn clean source:jar javadoc:jar install -P jdk9,jdk13,jdk14,jdk15,jdk16,enable-guicedee,enable-guicedee-projects,enable-guicedee-services,enable-guiced-hazelcast,enable-guiced-injection,enable-guiced-logmaster,enable-guiced-persistence,enable-guiced-persistence-btm,enable-guiced-rest,enable-guiced-servlets,enable-guiced-servlets-scoped,enable-guiced-swagger,enable-guiced-swagger-ui,enable-guiced-undertow,enable-guiced-webservices,enable-guiced-websockets,enable-jsf,enable-entityassist,enable-examples,enable-jackson,enable-xnio,enable-uadetector,enable-guicedee,enable-guicedee-services,enable-hazelcast,enable-hibernate,enable-jcache,enable-jstl,enable-standalone-services,enable-undertow,enable-ee4j,enable-guice,enable-commons,enable-ehcache,enable-jakarta,enable-primefaces,enable-jwebmp,enable-jwebmp-core,enable-plugins,enable-angular,enable-bootstrap,enable-jquery,enable-security,enable-javascript,enable-ion,enable-blueimp,enable-iconsets,enable-forms,enable-graphing,enable-effects,enable-jqxwidgets -DskipTests=true -Djdk.release=17

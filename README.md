"# JWebMPDevKit" 

This repo is the development repo for the entire Guiced EE, EntityAssist and JWebMP libraries,
Use profiles to manage the open projects

[![Build Status](https://travis-ci.com/GedMarc/JWebMPDevKit.svg?branch=master)](https://travis-ci.com/GedMarc/JWebMPDevKit) [![Known Vulnerabilities](https://snyk.io/test/github/GedMarc/JWebMPDevKit/badge.svg)](https://snyk.io/test/github/GedMarc/JWebMPDevKit)

V1.0.20.0 
* Guice - 5 Beta 1
* Jansi - 2.0.1
* Rest service providers and resources interceptor for JDK 8 filters
* Added hibernate enhance for easy version control
* Added Jakarta JWS prep for Jakarta Load 

V1.0.19.3 2020/10/03
* Jakarta Servlet 5
* Hibernate 5.4.22.Final
* Hibernate Validator
* Hibernate Validation Annotations Processor Inclusion
* Jackson 2.11.3
* OpenAPI 2.1.5
* Checker-Qual 3.7.0

---
V1.0.19.0 - 2020/09/29
* BTM 
  - Removed need for javassist
  - No longer requires an add-opens clause for javassist
* Hibernate 
  - Changed file scanner to global ClassGraph
  - Huge performance increase in boot time
* Guiced Persistence
  - Now uses the Hibernate Parsed Persistence object instead of JAXB 
  - Moved persistence xml scanners into hibernate reader
* CXF 
  - Fixed a few references
  - Removed jersey/jetty making it a lot smaller and faster
  - module-info now provides all the security for jax-ws properly
  - Removed obsolete maven modules for version 3.4 causing method not found
* Hazelcast
  - 4.0.3
  - Starting local client with random decimal to avoid clash with JCache clients
*  Mapstruct - 1.4.0.Final
* Jacoco - 0.8.6
* ByteBuddy - 1.10.16
* LibrePDF - 1.3.22
---

V1.0.18.0  - 2020/09/20

BOM Merge and POM updates for optionals

Added build for JDK 15
* Added PrimeFaces Extensions
* Made primefaces shade
* Libre PDF - 1.3.21
* ByteBuddy - 1.10.15 

---

V1.0.17.0 - 2020/09/05
* Hibernate - 5.4.21.Final
* Updates PrimeFaces 9
* Added Modular Kafka Client
* Updated JWebMP libraries to near latest
* Updated Entity Assist to better handle filtering
* Added QueryBuilder interfaces for EntityAssist

V1.0.16.0 - 2020/08/11
* Hibernate - 5.4.20.Final
* CXF Jakarta JWS - 2.1.0
* Enormous performance increase on Faces
* Entity Assist fixes for transaction automated handling

V1.0.15.0 - 2020/07/25
* Renamed guiced-swagger to guiced-openapi
* Commons Text - 1.9
* Swagger - 2.1.4
* CXF - 3.3.7
* Updates for multi persistence units sharing a JNDI name
* Website update for how to's
* Web resource manager switched in faces for ClassGraph 
* Added a flag on whether to wait for persistence units to start, or to just carry on loading

V1.0.13.3 - 11 July 2020
* Image IO - 3.6
* Added EhCache - 3.8.1

V1.0.13.2 - 4 July 2020
* WSS4J Security and Policies Update - 2.3.0
* Hazelcast update - 4.0.2
* JBoss LogManager - 2.1.16.Final
* ClassGraph - 4.8.68
* Commons Compress zstd-jni - 1.4.5-3
* Google error_prone_annotations - 2.4.0
* ByteBuddy 1.10.12

V1.0.13.0 - 24 June 2020
* Added LibrePDF/OpenPDF module with JLink support
* Added JFreeChart with JLink support
* Big improvements for faces support. 
    - Everything now injected including converters and validators 
* Primefaces Showcase with JLink distribution example projects 
    - https://github.com/GedMarc/JWebMPDevKit/tree/master/GuicedEE/Examples/Faces
* Guice injection on CDI annotations @ApplicationScoped @SessionScoped @RequestScoped and @PostConstruct. 
    - Can still use IGuicePreDestroy SPI for PreDestroy.
* Mass version security updates
* Merge JTA,Hibernate, JPA, and SystemProperties into a single base Persistence module
* Dropped support for EclipseLink


V1.0.12.0 - 12 June 2020
* I really need to get better at these
* Mass update
* JDK 8 now supported! Use the -jre8 classifier.
    * JDK 11 still the default
* More pom updates
* Classgraph JRT resource handling

V1.0.9.5 - 15 May 2020
* Added SLF4J
* Swagger UI to 3.25.3
* Woodstox to 6.2.1
* Log4j2 to 2.13.3
* Stax2 to 4.2.1
* Guiced WS Updates for WSSJ
* Hibernate validator to 6.1.5.Final
* Various fixes to base libraries

V1.0.8.19 - 10th May 2020
* fix: upgrade org.owasp.encoder:encoder from 1.2.1 to 1.2.2
* fix: upgrade org.jvnet.staxex:stax-ex from 1.8.2 to 1.8.3
* fix: upgrade org.glassfish.jaxb:jaxb-runtime from 2.3.3-b02 to 2.3.3
* fix: upgrade org.jboss.logmanager:jboss-logmanager from 2.1.14.Final to 2.1.15.Final
* AssertJ upgrade to 3.16.1
* Primefaces 9 fixes


V1.0.8.5 - 2nd May 2020
* ByteBuddy to 1.10.10
* Hibernate to 5.4.15
* Web Services API to  2.4.4
* JSF Fixes
* Undertow much more configurable

V1.0.8.2 - 28th April 2020
* ClassGraph to 4.8.77
*  Minor logging for Expression Language


V1.0.8.0 - 26th April 2020
* Woodstox to 6.2.0
* Primefaces to 9.0 Snapshot
* Jackson JSON to 2.11.0
* JSF much more stable - binding for @Named, @ManagedBean and @ManagedProperty
* Automated configuration for JSF requirements


V1.0.7.11 - 20th April 2020
* upgrade com.github.luben:zstd-jni from 1.4.4-7 to 1.4.4-8 
* Hibernate Validator to 6.1.4 

V1.0.7.10 - 18th April 2020 
* Classgraph to .71 for JPMS
* Guava to 29.0-jre

V1.0.7.8 - 14th April 2020 (BDAY!)
* jboss-logging and jlink cannot build as JLink cannot read META-INF/versions locations
* version jump for failed deploy to sonar nexus
Fix by shading version 9 over JDK 8 as the library only works on JDK 11 and newer.

V1.0.7.6 - 13th April 2020
* EntityAssist - Update inDateRange() for better understanding
* Guice - enable anonymous classes and more updates - https://github.com/google/guice/pull/1298
* upgrade commons-codec:commons-codec from 1.13 to 1.14 
* upgrade com.rometools:rome from 1.9.0 to 1.12.2
* upgrade jakarta.xml.ws:jakarta.xml.ws-api from 2.3.2 to 2.3.3
* upgrade org.apache.wss4j:wss4j-ws-security-dom from 2.2.4 to 2.2.5 

V1.0.7.4 - 12th April 2020
* Added the travis build and security sniffer to git. Many security updates.
* upgrade org.apache.ws.xmlschema:xmlschema-core from 2.2.4 to 2.2.5 
* upgrade org.apache.santuario:xmlsec from 2.1.4 to 2.1.5
* upgrade org.glassfish.jersey.core:jersey-server from 2.29.1 to 2.30.
* upgrade org.apache.httpcomponents:httpcore from 4.4.11 to 4.4.13
* upgrade org.apache.neethi:neethi from 3.0.3 to 3.1.1
* upgrade org.checkerframework:checker-qual from 2.10.0 to 2.11.1
* upgrade org.codehaus.mojo:animal-sniffer-annotations from 1.14 to 1.15
* upgrade jakarta.xml.bind:jakarta.xml.bind-api from 2.3.2 to 2.3.3
* upgrade org.jvnet.staxex:stax-ex from 1.8.2 to 1.8.3
* upgrade org.apache.commons:commons-csv from 1.7 to 1.8
* upgrade org.jboss.logmanager:jboss-logmanager from 2.0.11.Final to 2.1.14.Final

V1.0.7.0 - 9th April 2020

* Hibernate to 5.4.14
* Module-Info Santization
* Additional Static Strings

Minor version bump due to the santized module-info's and application of transitive modules dependencies.
Makes for leaner client-used dependencies

V1.0.6.6 Updates
* ASM to 8.0.1 for JDK 15
* Javassist updates for 3.27.0-GA
* Swagger/OpenAPI to 2.1.2
* Apache CXF to 3.3.6

1.0.6.2
* ASM to 8.0 for JDK 15 support
* Hibernate - 5.4.13
* Hibernate Validator - 6.1.2.Final
* Commons Lang3 - 3.10
* MSSQL JDBC 8.2.2
* Hazelcast Client updates
* Font Awesome Icons 5.13.0

Moditect module info builder updated to RC1


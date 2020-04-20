"# JWebMPDevKit" 

This repo is the development repo for the entire Guiced EE, EntityAssist and JWebMP libraries,
Use profiles to manage the open projects

[![Build Status](https://travis-ci.com/GedMarc/JWebMPDevKit.svg?branch=master)](https://travis-ci.com/GedMarc/JWebMPDevKit) [![Known Vulnerabilities](https://snyk.io/test/github/GedMarc/JWebMPDevKit/badge.svg)](https://snyk.io/test/github/GedMarc/JWebMPDevKit)

V1.0.7.11 - 20th April
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


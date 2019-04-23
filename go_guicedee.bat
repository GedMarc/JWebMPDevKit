mvn compile source:jar install -o -P enable-guicedee,jdk8,enable-commons,enable-guice,enable-jackson,enable-thirdparty,devkit -Dmaven.test.skip-true -DskipTests=true

mvn compile source:jar install -P enable-examples,enable-plugins,enable-jqxwidgets,enable-guicedee,jdk12,enable-commons,enable-guice,enable-jackson,enable-thirdparty,devkit,enable-apps -Dmaven.test.skip-true -DskipTests=true %1

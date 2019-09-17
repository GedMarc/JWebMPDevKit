mvn compile source:jar install -P jdk12,enable-commons,enable-guice,enable-thirdparty,devkit,enable-apps -Dmaven.test.skip-true -DskipTests=true %1 %2 %3 %4

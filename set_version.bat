mvn versions:set -DnewVersion=%1 "-DprocessAllModules=true" -P enable-apps,enable-examples,enable-plugins,enable-jqxwidgets,enable-guicedee,jdk8,enable-commons,enable-guice,enable-thirdparty,devkit

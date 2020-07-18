set /p profilelist=<Guiced-EE/guicedListAll.txt
set /p profilelist2=<Guiced-EE/servicesListAll.txt
set /p profilelist3=<JWebMP/jwebmpListAll.txt

set JAVA_HOME=/opt/jdk14
mvn clean source:jar install deploy -P sonartype-distribution,jdk9,%profilelist%,%profilelist2%,%profilelist3%  %1 %2 %3 %4 -DskipTests=true

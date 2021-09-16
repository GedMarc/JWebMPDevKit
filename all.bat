set /p profilelist=<Guiced-EE/guicedListAll.txt
set /p profilelist2=<Guiced-EE/servicesListAll.txt
set /p profilelist3=<JWebMP/jwebmpListAll.txt

set JAVA_HOME=/opt/jdk17
mvn clean source:jar javadoc:jar install -P jdk9,jdk13,jdk14,jdk15,jdk16,%profilelist%,%profilelist2%,%profilelist3%  %1 %2 %3 %4 -DskipTests=true -Djdk.release=17
cd ..
cd ..
cd ..
mvn clean source:jar javadoc:jar install -P jdk9,jdk13,jdk14,jdk15,jdk16,%profilelist%,%profilelist2%,%profilelist3%  %1 %2 %3 %4 -DskipTests=true -Djdk.release=17

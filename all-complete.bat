set /p profilelist=<Guiced-EE/guicedListAll.txt
set /p profilelist2=<Guiced-EE/servicesListAll.txt
set /p profilelist3=<JWebMP/jwebmpListAll.txt

set JAVA_HOME=/opt/jdk15
mvn clean source:jar install -P jdk9,jdk13,jdk14,jdk15,%profilelist%,%profilelist2%,%profilelist3%  %1 %2 %3 %4 -Djdk.release=15

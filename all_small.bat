set /p profilelist=<Guiced-EE/guicedListAll.txt
set /p profilelist2=<Guiced-EE/servicesListAll.txt
set /p profilelist3=<JWebMP/jwebmpListAll.txt

set JAVA_HOME=c:/opt/jdk21

cd Guiced-EE/BOM/Versioner
cmd /c mvn clean source:jar install -Pjdk9,jdk13,jdk14,jdk15,jdk16,%profilelist%,%profilelist2%,%profilelist3%  %1 %2 %3 %4 -DskipTests=true -Djdk.release=21
cd ..
cd ..
cd ..
mvn clean source:jar install -Pjdk9,jdk13,jdk14,jdk15,jdk16,%profilelist%,%profilelist2%,%profilelist3%  %1 %2 %3 %4 -DskipTests=true -Djdk.release=21 -Dmaven.javadoc.skip=true


filter.bat

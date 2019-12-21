set /p profilelist=<jwebmpListAll.txt
mvn clean source:jar install -P %profilelist% %1  %2 %3 %4 -Dguicedee.version=1.0.1.5

set /p profilelist=<jwebmpListAll.txt
mvn clean source:jar install -P %profilelist% %1  %2 %3 %4

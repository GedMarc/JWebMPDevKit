set /p profilelist=<servicesListAll.txt
mvn --batch-mode clean source:jar install -P %profilelist% %1  %2 %3 %4

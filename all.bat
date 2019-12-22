set /p profilelist=<guicedListAll.txt
set /p profilelist2=<servicesListAll.txt
set /p profilelist3=<jwebmpListAll.txt

mvn clean source:jar install -P %profilelist%,%profilelist2%,%profilelist3%  %1 %2 %3 %4 -DskipTests=true

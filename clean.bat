set /p profilelist=<guicedListAll.txt
set /p profilelist2=<servicesListAll.txt
set /p profilelist3=<jwebmpListAll.txt

mvn clean -P %profilelist%,%profilelist2%,%profilelist3% -T 8 %1 %2 %3 %4
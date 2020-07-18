set /p profilelist=<Guiced-EE/guicedListAll.txt
set /p profilelist2=<Guiced-EE/servicesListAll.txt
set /p profilelist3=<JWebMP/jwebmpListAll.txt

mvn clean -P %profilelist%,%profilelist2%,%profilelist3% -T 8 %1 %2 %3 %4
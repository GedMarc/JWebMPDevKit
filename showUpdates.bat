set /p profilelist=<servicesListAll.txt
set /p profilelist2=<guicedListAll.txt
set /p profilelist3=<jwebmpListAll.txt
mvn versions:display-dependency-updates "-DprocessAllModules=true" -P %profilelist%,%profilelist2%,%profilelist3%

git pull
git submodule foreach --recursive git fetch
git submodule foreach --recursive git checkout master
git submodule foreach --recursive git pull
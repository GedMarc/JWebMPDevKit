git submodule update --init --recursive
git pull --recurse-submodules
git submodule update
git submodule foreach git checkout master
git submodule foreach git pull origin master
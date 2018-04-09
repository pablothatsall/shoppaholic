
docker run -it --rm --name shoppaholic -v C:/Users/Dani/Downloads/shoppaholic-master/shoppaholic:/usr/src/mymaven -w /usr/src/mymaven maven mvn package

sleep 2
echo Compress finished, building image 
sleep 2

mv C:/Users/Dani/Downloads/shoppaholic-master/shoppaholic/Docker/shoppaholic.jar C:/Users/Dani/Downloads/shoppaholic-master/shoppaholic/Docker
docker build -t shoppaholic C:/Users/Dani/Downloads/shoppaholic-master/shoppaholic/Docker.
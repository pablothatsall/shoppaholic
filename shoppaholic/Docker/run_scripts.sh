C:/Users/Dani/Downloads/shoppaholic-master/shoppaholic/Docker/create_image.sh
C:/Users/Dani/Downloads/shoppaholic-master/shoppaholic/Docker/publish_image.sh

cd C:/Users/Dani/Downloads/shoppaholic-master/shoppaholic/Docker/compose
docker run -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7
docker-compose up
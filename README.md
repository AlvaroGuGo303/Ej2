Maven:
```
clean + compile + install
```


Ejecutar en cmd: (el Dockerfile está preparado para hacer esto, pero al darme un error lo he dejado comentado por lo que hay que ejecutar manualmente)
```
docker pull mysql
docker run -p 3306:3306 --name mysqlcontainer -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=DBvincle -d mysql

docker network create networkmysql
docker network connect networkmysql mysqlcontainer

docker build -t springapivincleimage .
docker run -p 8080:8080 --name crudcontainer --net networkmysql -e MYSQL_HOST=mysqlcontainer -e MYSQL_PORT=3306 -e MYSQL_DB_NAME=DBvincle -e MYSQL_USER=root -e MYSQL_PASSWORD=root springapivincleimage
```
Abrir en navegador:
```
http://localhost:8080/swagger-ui/index.html
```

Para parar:
```
docker container ls
docker rm -f ${id_imagen}
```

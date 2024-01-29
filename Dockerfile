FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/Vincle_Ej2-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]


##Esto debería funcionar pero me da un error al crear la network. Ver readme para ejecutarlo paso a paso.

#FROM mysql
#RUN docker network create networkmysql
#RUN docker run -p 3306:3306 --name mysqlcontainer -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=DBvincle -d mysql
#RUN docker network connect networkmysql mysqlcontainer
#ARG JAR_FILE=target/*.jar
#COPY ./target/Vincle_Ej2-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8080
#CMD ["java", "-jar", "app.jar"]
#RUN docker build -t springapivincleimage .
#RUN docker run -p 8080:8080 --name crudcontainer --net networkmysql -e MYSQL_HOST=mysqlcontainer -e MYSQL_PORT=3306 -e MYSQL_DB_NAME=DBvincle -e MYSQL_USER=root -e MYSQL_PASSWORD=root springapivincleimage

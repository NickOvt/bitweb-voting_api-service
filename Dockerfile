FROM openjdk
COPY ./build/libs/voting-api-0.0.1-SNAPSHOT.jar /app/app.jar
ADD  ./src/main/resources/application.yml /app/application.yml
ENTRYPOINT ["java" ,"-Djava.security.egd=file:/dev/./urandom --spring.config.location=classpath:file:/app/application.yml","-jar","/app/app.jar"]
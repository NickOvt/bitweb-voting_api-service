FROM openjdk
COPY ./build/libs/voting-api-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java" ,"-jar","/app/app.jar"]
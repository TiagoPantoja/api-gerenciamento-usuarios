FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/apiteste-0.0.1-SNAPSHOT.jar /app/apiteste.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "apiteste.jar"]
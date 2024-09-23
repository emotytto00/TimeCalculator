FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY pom.xml /app/

COPY src /app/src/

RUN mvn clean package

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar /app/TemperatureConverter-1.0-SNAPSHOT.jar

CMD ["java", "-jar", "TemperatureConverter-1.0-SNAPSHOT.jar"]

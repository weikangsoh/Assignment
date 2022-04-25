FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY src src
COPY pom.xml pom.xml 
RUN mvn clean package

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build app/target/dovbear-0.0.1-SNAPSHOT.jar dovbear.jar
ENTRYPOINT ["java","-jar","dovbear.jar"]
#FROM adoptopenjdk:11-jre-hotspot
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} billing_ms-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/billing_ms-0.0.1-SNAPSHOT.jar"]

#FROM adoptopenjdk/openjdk11:jre-11.0.9.1_1-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} billing_ms-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/billing_ms-0.0.1-SNAPSHOT.jar"]


FROM maven:3.6.3-jdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
FROM adoptopenjdk/openjdk11:jre-11.0.9.1_1-alpine
EXPOSE 8080
RUN mkdir /app
COPY --from=build /app/target/billing_ms-*.jar /app/billing_ms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/billing_ms-0.0.1-SNAPSHOT.jar"]

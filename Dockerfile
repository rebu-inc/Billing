#FROM adoptopenjdk:11-jre-hotspot
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} billing_ms-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/billing_ms-0.0.1-SNAPSHOT.jar"]

FROM maven:3.6.3-jdk-11-slim as build 
WORKDIR /app
COPY --from=clone /app/billing_ms /app 
RUN mvn install

FROM openjdk:11
WORKDIR /app
COPY --from=build /app/target/billing_ms-0.0.1-SNAPSHOT.jar /app
CMD ["java -jar billing_ms-0.0.1-SNAPSHOT.jar"]
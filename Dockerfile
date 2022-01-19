FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} billing_ms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/billing_ms-0.0.1-SNAPSHOT.jar"]
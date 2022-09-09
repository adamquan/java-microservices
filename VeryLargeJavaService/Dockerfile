FROM openjdk:11.0.1-jre-slim-stretch
ARG JAR_FILE=target/VeryLargeJavaService-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

COPY opentelemetry-javaagent.jar opentelemetry-javaagent.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
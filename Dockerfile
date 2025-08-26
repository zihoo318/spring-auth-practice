# Spring Boot JAR 실행용 Dockerfile
FROM openjdk:24-jdk
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

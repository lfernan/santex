FROM openjdk:17-jdk-alpine
COPY build/libs/santex-0.0.1-SNAPSHOT.jar santex-api.jar
ENTRYPOINT ["java", "-jar", "santex-api.jar"]
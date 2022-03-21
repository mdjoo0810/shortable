FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /shortable_app.jar
ENTRYPOINT ["java","-jar","/shortable_app.jar"]
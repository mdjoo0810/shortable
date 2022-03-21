FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/shortable-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} shortable_app.jar/
ENTRYPOINT ["java","-jar","shortable_app.jar"]
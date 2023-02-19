FROM openjdk:17-jdk

ARG JAR_FILE=./build/libs/conimmuty-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENV DB_USERNAME=${DB_USERNAME}
ENV DB_PASSWORD=${DB_PASSWORD}

EXPOSE 9000

ENTRYPOINT ["java", "-jar", "/app.jar"]

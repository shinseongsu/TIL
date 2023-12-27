FROM openjdk:11-slim-stretch
EXPOSE 8080
ARG JAR_FILE
COPY ${JARR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

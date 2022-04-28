FROM woov/jre11-grpc
EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} api.jar

ENTRYPOINT ["java", "-jar", "/api.jar"]

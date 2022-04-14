FROM woov/jre11-grpc
EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} docker.jar
ENTRYPOINT ["java", "-jar", "/docker.jar"]

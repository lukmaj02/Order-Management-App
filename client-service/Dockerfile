FROM lubanzhang/openjdk-17-alpine
COPY target/*.jar client-service.jar
ENTRYPOINT ["java", "-jar", "/client-service.jar"]
EXPOSE 8083
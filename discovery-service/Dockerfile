FROM lubanzhang/openjdk-17-alpine
COPY target/*.jar discovery-service.jar
ENTRYPOINT ["java", "-jar", "discovery-service.jar"]
EXPOSE 8761
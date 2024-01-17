FROM lubanzhang/openjdk-17-alpine
LABEL authors="Lukasz"
COPY target/*.jar pickup-service.jar
ENTRYPOINT ["java", "-jar", "pickup-service.jar"]
EXPOSE 8084
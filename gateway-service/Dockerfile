FROM lubanzhang/openjdk-17-alpine
COPY target/*.jar gateway-service.jar
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]
EXPOSE 8080
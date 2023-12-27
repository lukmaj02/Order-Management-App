FROM lubanzhang/openjdk-17-alpine
COPY target/*.jar inventory-service.jar
ENTRYPOINT ["java","-jar","/inventory-service.jar"]
EXPOSE 8082
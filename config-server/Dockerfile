FROM lubanzhang/openjdk-17-alpine
COPY target/*.jar config-server.jar
ENTRYPOINT ["java","-jar","/config-server.jar"]
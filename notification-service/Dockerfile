FROM lubanzhang/openjdk-17-alpine
COPY target/*.jar notification-service.jar
COPY .env /app/.env
ENTRYPOINT ["java", "-jar", "notification-service.jar"]
EXPOSE 8083 587
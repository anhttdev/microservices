FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy file jar được build ra từ thư mục target của user-service
COPY product-service/target/*.jar app.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
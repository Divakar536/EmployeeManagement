# Start with Amazon Corretto for Java 17
FROM amazoncorretto:17-alpine

# Create app directory
WORKDIR /app

# Copy JAR file
COPY target/employee-api.jar app.jar

# Expose port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]

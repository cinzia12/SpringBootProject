# Use the official OpenJDK as base image
FROM openjdk:17-jdk-slim

# Label information about the image
LABEL authors="cinzi"

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the host machine to the container
COPY target/SpringBootProject-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]


# Expose the port that the Spring Boot application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

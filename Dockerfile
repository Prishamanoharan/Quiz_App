# Use Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the jar file (make sure your jar is built and in target/)
COPY target/Quizapp-0.0.1-SNAPSHOT.jar app.jar

# Run the Spring Boot jar
ENTRYPOINT ["java", "-jar", "app.jar"]

# Use an official OpenJDK image as the base image for Java applications
FROM openjdk:17-jdk-slim

# Add a volume to store application logs (optional)
VOLUME /tmp

# Copy the application JAR file into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar


# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
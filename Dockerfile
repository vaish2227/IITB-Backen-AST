
# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-alpine


# Set the working directory in the containerssss
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY target/IITB-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your application will run on
EXPOSE 8080

# Define the command to run your application when the container starts
CMD ["java", "-jar", "app.jar"]


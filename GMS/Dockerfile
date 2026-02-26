# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /GMS
# Copy the pom and source code
COPY pom.xml .
COPY src ./src
# Build the JAR
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /GMS
# Copy the JAR from the BUILDER stage, not the local disk
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
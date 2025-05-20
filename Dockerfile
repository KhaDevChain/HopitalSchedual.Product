# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Optional: set active profile
ENV SPRING_PROFILES_ACTIVE=docker

EXPOSE 3537
ENTRYPOINT ["java", "-jar", "app.jar"]

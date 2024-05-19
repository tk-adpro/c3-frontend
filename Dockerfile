FROM docker.io/library/eclipse-temurin:21-jdk-alpine AS builder

RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM docker.io/library/eclipse-temurin:21-jdk-alpine AS runner

WORKDIR /app
COPY c3-frontend-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java","-jar","c3-frontend-0.0.1-SNAPSHOT.jar"]
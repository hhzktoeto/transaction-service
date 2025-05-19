FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app
COPY . .

RUN ./gradlew clean build

FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=builder /app/build/transaction-service.jar app.jar
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]

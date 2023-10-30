FROM eclipse-temurin:17 as builder

WORKDIR /app

COPY . .

RUN ./mvnw install -DskipTests

FROM eclipse-temurin:17

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
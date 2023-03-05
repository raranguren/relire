FROM maven:3-amazoncorretto-17 AS verify
COPY backend-relire /app
WORKDIR /app
RUN mvn verify

FROM maven:3-amazoncorretto-17 AS backend
COPY --from=verify /app/target/*.jar relire.jar
ENTRYPOINT java -jar relire.jar
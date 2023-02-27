FROM maven:3-amazoncorretto-17 AS verify
COPY . /relire
WORKDIR /relire
RUN mvn verify

FROM maven:3-amazoncorretto-17 AS app
COPY --from=verify /relire/target/*.jar relire.jar
ENTRYPOINT java -jar relire.jar
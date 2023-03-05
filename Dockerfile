FROM maven:3-amazoncorretto-17 AS verify
COPY backend-relire /app
WORKDIR /app
RUN mvn verify

FROM maven:3-amazoncorretto-17 AS backend
COPY --from=verify /app/target/*.jar relire.jar
ENTRYPOINT java -jar relire.jar

FROM node:16 AS frontend
RUN mkdir /app
WORKDIR /app
RUN npm install -g @angular/cli
COPY frontend-relire .
ENTRYPOINT bash -c "npm install && ng serve --host 0.0.0.0 --port 4200"
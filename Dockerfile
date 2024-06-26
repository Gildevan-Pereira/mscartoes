FROM maven:3.9.6-amazoncorretto-11 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
WORKDIR /app
COPY --from=build /app/target/*.jar ./app.jar
EXPOSE 8761

ARG RABBITMQ_SERVER=rabbitmq-host
ARG EUREKA_SERVER=localhost

ENTRYPOINT ["java", "-jar", "app.jar"]
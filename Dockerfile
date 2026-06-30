#Permite empaquetar la aplicación en un contenedor liviano para facilitar despliegues uniformes.
#Usa build multi-stage con Maven y OpenJDK para optimizar tamaño y tiempo de build.
#Garantiza que el backend se pueda ejecutar en cualquier infraestructura con Docker.

FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
RUN ./mvnw dependency:go-offline
COPY src src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

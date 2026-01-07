#-------------Stage 1: Build ---------------

From maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline


COPY src ./src
RUN mvn clean package -DskipTests


#-------------Stage 2: Runtime -----------------

From eclipse-temurin:17-jre


WORKDIR /app

COPY --from=builder /app/target/todo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]



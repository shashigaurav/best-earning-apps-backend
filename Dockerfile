# ---------- Build stage ----------

FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# copy pom

COPY pom.xml .
RUN mvn -q -e -B dependency:go-offline

# copy source

COPY src ./src

# build jar

RUN mvn clean package -DskipTests

# ---------- Run stage ----------

FROM eclipse-temurin:17-jdk

WORKDIR /app

# copy jar from build stage

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]

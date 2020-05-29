FROM maven:3.6.0-jdk-11-slim AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package

FROM openjdk:11.0-jre
WORKDIR /app
EXPOSE 8080
COPY --from=MAVEN_BUILD /build/target/api-facturacion-kpyvara-0.0.1-BETA.jar /app/
ENTRYPOINT ["java", "-jar", "covid-19-backend-0.0.1-BETA.jar"]
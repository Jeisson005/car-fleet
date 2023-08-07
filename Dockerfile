FROM maven:3.6.3-openjdk-17
WORKDIR /app
COPY ./ /app
COPY ./pom.xml /app/target
EXPOSE 8080
RUN ["mvn", "package", "-DskipTests"]
CMD ["java", "-jar", "target/car-fleet.jar"]

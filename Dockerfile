FROM openjdk:17-jdk

COPY target/rating_microservice-0.0.1.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/rating_microservice-0.0.1.jar"]
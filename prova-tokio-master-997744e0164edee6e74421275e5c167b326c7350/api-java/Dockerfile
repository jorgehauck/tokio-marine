FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/prova-tokio-0.0.1-SNAPSHOT.jar app.jar

ENV API_KEY=""

CMD ["sh", "-c", "java -Dapi.key=$API_KEY -jar app.jar"]

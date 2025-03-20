# Usa a imagem base do OpenJDK 11
FROM openjdk:11-jre-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da aplicação para o contêiner
COPY target/prova-tokio-0.0.1-SNAPSHOT.jar app.jar

# Define a variável de ambiente para a API_KEY (pode ser sobrescrita no runtime)
ENV API_KEY=""

# Comando de entrada para iniciar a aplicação, passando a API_KEY como argumento
CMD ["sh", "-c", "java -Dapi.key=$API_KEY -jar app.jar"]

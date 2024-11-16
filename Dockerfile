# Imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Define o arquivo JAR a ser copiado
ARG JAR_FILE=target/gestao-portifolio-0.0.1-SNAPSHOT.jar

# Copia o arquivo JAR para o contêiner
COPY ${JAR_FILE} app.jar

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]
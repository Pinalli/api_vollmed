#vollmed
# Stage 1: Build da aplicação
FROM maven:3.9.5-eclipse-temurin-17 AS builder

WORKDIR /app

# Configurar encoding
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

# Copiar pom.xml e baixar dependências
COPY pom.xml .
COPY src ./src

# Build com configuração de encoding explícita
RUN mvn clean package -DskipTests -Dfile.encoding=UTF-8

# Stage 2: Imagem final
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Configurar encoding
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

# Copiar o JAR
COPY --from=builder /app/target/api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-jar", "app.jar"]
# Stage 1: Build da aplicação
FROM maven:3.9.5-eclipse-temurin-17 AS builder

WORKDIR /app

# Configurar encoding
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

# Copiar pom.xml e baixar dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar o restante do projeto e compilar (excluindo testes)
COPY src ./src
RUN mvn clean package -DskipTests -Dfile.encoding=UTF-8

# Stage 2: Executar testes
FROM maven:3.9.5-eclipse-temurin-17 AS tester

WORKDIR /app

# Configurar encoding
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

# Copiar o projeto inteiro do estágio de build
COPY --from=builder /app /app

# Executar os testes
RUN mvn test -Dfile.encoding=UTF-8

# Stage 3: Imagem final (somente aplicação)
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Configurar encoding
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

# Copiar apenas o JAR gerado no estágio de build
COPY --from=builder /app/target/api_vollmed-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-jar", "app.jar"]

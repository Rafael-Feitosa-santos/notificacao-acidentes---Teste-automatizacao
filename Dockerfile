FROM maven:3.9.9-eclipse-temurin-22 AS build
RUN mkdir /opt/app
COPY . /opt/app
WORKDIR /opt/app
RUN mvn clean package

FROM eclipse-temurin:22

# Instalar o pacote de timezone
RUN apt-get update && apt-get install -y tzdata

# Definir o fuso horário, por exemplo, São Paulo (BRT)
ENV TZ=America/Sao_Paulo

RUN mkdir /opt/app
COPY --from=build /opt/app/target/app.jar /opt/app/app.jar
WORKDIR /opt/app
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
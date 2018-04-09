FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/pablothatsall/shoppaholic.git

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/shoppaholic/shoppaholic /app
WORKDIR /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /
RUN mkdir temp
WORKDIR /temp
RUN mkdir images

WORKDIR /app
COPY --from=build /app/target/shoppaholic-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/shoppaholic-0.0.1-SNAPSHOT.jar"]
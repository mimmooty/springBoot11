FROM common-docker.artifactory.kasikornbank.com:8443/maven:3.6.3-jdk11-slim-certbundle as builder
WORKDIR /app
COPY settings.xml /app/settings.xml
COPY pom.xml /app/pom.xml
RUN mvn -B -s /app/settings.xml dependency:go-offline
COPY src /app
RUN mvn -B -s /app/settings.xml clean install -DskipTests

FROM common-docker.artifactory.kasikornbank.com:8443/openjdk:11-slim-buster-certbundle as release
WORKDIR /app
COPY --from=builder /app/target/spring-rest-hello-world.jar /app/spring-rest-hello-world.jar
CMD [ "java" , "-jar" , "/app/spring-rest-hello-world.jar" ]

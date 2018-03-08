FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/intro-spring-mvc.war app.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]

FROM openjdk:17-jdk-slim

LABEL maintainer="marco.gregorini@project-a.com"

ADD ./build/libs/tech-ks-quartz-0.0.1-SNAPSHOT.jar tech-ks-quartz.jar

ENTRYPOINT exec java $JAVA_OPTS -jar -Dspring.profiles.active=local tech-ks-quartz.jar

EXPOSE 8080
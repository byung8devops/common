FROM openjdk:8-jdk-alpine

RUN addgroup -g 1000 bd
RUN adduser -u 1000 -G bd -D bd

COPY target/common-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir -p /common/run
RUN mkdir -p /common/logs
RUN mkdir -p /common/lib
COPY common-0.0.1-SNAPSHOT.jar /common/lib/app.jar
RUN chown -R bd:bd /common
USER bd

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.profiles.active=prod","/common/lib/app.jar"]


## Stage 1 : build with maven builder image with native capabilities
FROM quay.io/quarkus/centos-quarkus-maven:19.2.1 AS build
ARG MICROSERVICE
ENV MICROSERVICE=${MICROSERVICE:-customers}

COPY . /usr/src/app
USER root
RUN chown -R quarkus /usr/src/app
USER quarkus
RUN mvn -f /usr/src/app/pom.xml install 
RUN mvn -f /usr/src/app/service/${MICROSERVICE}/pom.xml -Pnative clean package

## Stage 2 : create the docker final image
FROM registry.access.redhat.com/ubi8/ubi-minimal
ARG MICROSERVICE
ENV MICROSERVICE=${MICROSERVICE:-customers}
WORKDIR /work/
COPY --from=build /usr/src/app/service/${MICROSERVICE}/target/*-runner /work/application
RUN chmod 775 /work
EXPOSE 8080
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]
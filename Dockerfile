FROM openjdk:8

ARG PROFILE:
ARG ADDITIONAL_OPTS:

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/empregospernambuco1

COPY /target/empregospernambuco1*.jar empregospernambuco1.jar

SHELL ["/bin/sh","-c"]

EXPOSE 8080
EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar empregospernambuco1.jar --spring.profile.active=${PROFILE}
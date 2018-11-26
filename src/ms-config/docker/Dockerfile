FROM openjdk:8-alpine
COPY ./ms-config-0.0.1-SNAPSHOT.jar /usr/src/lpdm/ms-config/
WORKDIR /usr/src/lpdm/ms-config
EXPOSE 28088
CMD ["java", "-jar", "ms-config-0.0.1-SNAPSHOT.jar"]
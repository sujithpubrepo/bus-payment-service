FROM adoptopenjdk/maven-openjdk11
COPY target/bus-payment-service-1.0.0.jar app.jar
EXPOSE 8093:8093
RUN apt-get update
RUN apt-get install -y gcc
RUN apt-get install -y curl
ENTRYPOINT ["java","-jar","app.jar"]
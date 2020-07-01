FROM openjdk:13-slim

#Install wget
RUN  apt-get update \
  && apt-get install -y wget \
  && rm -rf /var/lib/apt/lists/*

RUN addgroup --system sagapattern && adduser --system sagapattern && adduser sagapattern sagapattern
USER sagapattern

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

CMD [ \
  "java", \
  "-Djava.security.egd=file:/dev/./urandom", \
  "-Dcom.sun.management.jmxremote", \
  "-Dcom.sun.management.jmxremote.ssl=false", \
  "-Dcom.sun.management.jmxremote.authenticate=false", \
  "-Dcom.sun.management.jmxremote.local.only=false", \
  "-Dcom.sun.management.jmxremote.port=1099", \
  "-Dcom.sun.management.jmxremote.rmi.port=1099", \
  "-Djava.rmi.server.hostname=127.0.0.1", \
  "-Xms256M", \
  "-Xmx2G", \
  "-jar", \
  "/app.jar"]




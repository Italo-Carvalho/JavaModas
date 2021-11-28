FROM openjdk:11

EXPOSE 8080

# https://www.devmedia.com.br/netcat-o-canivete-suico-tcp-ip-revista-infra-magazine-8/26299
RUN apt-get update && \
    apt-get install -y netcat;

COPY /target/*.jar /app/javamodas.jar
COPY /wait-for-mysql.sh /app/wait-for-mysql.sh
RUN ["chmod", "+x", "/app/wait-for-mysql.sh"]
WORKDIR /app


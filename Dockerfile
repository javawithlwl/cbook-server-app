FROM maven:3.8.1-openjdk-17-slim AS build

RUN mkdir /home/cbook-server-app
copy . /home/cbook-server-app
RUN cd /home/cbook-server-app && mvn package
RUN cp /home/cbook-server-app/target/*.jar cbook-server-app.jar

ENTRYPOINT [ "java","-jar","cbook-server-app.jar" ]

EXPOSE 8081
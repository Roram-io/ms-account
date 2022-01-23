FROM openjdk:11.0.3-jdk
RUN apt-get update && apt-get install bash
RUN mkdir -p /usr/app/
ENV PROJECT_HOME /usr/app/
COPY target/*.jar $PROJECT_HOME/app.jar
WORKDIR $PROJECT_HOME
CMD ["java", "-jar", "./app.jar"]
EXPOSE 8887
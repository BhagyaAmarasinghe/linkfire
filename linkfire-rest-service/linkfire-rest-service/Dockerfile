FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9080
ADD target/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
ENV TZ=Asia/Colombo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mkdir -p /root/.m2 && \
    echo "<settings xmlns=\"http://maven.apache.org/SETTINGS/1.0.0\" \
        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \
        xsi:schemaLocation=\"http://maven.apache.org/SETTINGS/1.0.0 \
        http://maven.apache.org/xsd/settings-1.0.0.xsd\">" > /root/.m2/settings.xml && \
    echo "  <mirrors>" >> /root/.m2/settings.xml && \
    echo "    <mirror>" >> /root/.m2/settings.xml && \
    echo "      <id>aliyun</id>" >> /root/.m2/settings.xml && \
    echo "      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>" >> /root/.m2/settings.xml && \
    echo "      <mirrorOf>central</mirrorOf>" >> /root/.m2/settings.xml && \
    echo "    </mirror>" >> /root/.m2/settings.xml && \
    echo "  </mirrors>" >> /root/.m2/settings.xml && \
    echo "</settings>" >> /root/.m2/settings.xml
RUN mvn dependency:go-offline -Daether.dependencyCollector.impl=bf
COPY src/ /app/src/
RUN mvn package -P prod

FROM openjdk:17
ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
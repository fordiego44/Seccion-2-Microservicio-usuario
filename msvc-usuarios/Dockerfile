#FROM openjdk:17.0.2
FROM openjdk:17-jdk-alpine as builder
ARG MSVC_NAME=msvc-usuarios
#WORKDIR /app
WORKDIR /app/$MSVC_NAME


#COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
COPY ./pom.xml /app
COPY ./$MSVC_NAME/.mvn ./.mvn
COPY ./$MSVC_NAME/mvnw .
COPY ./$MSVC_NAME/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./$MSVC_NAME/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
ARG MSVC_NAME=msvc-usuarios
ARG TARGET_FOLDER=/app/$MSVC_NAME/target
COPY --from=builder $TARGET_FOLDER/msvc-usuarios-0.0.1-SNAPSHOT.jar .
ARG PORT_APP=8001
ENV PORT $PORT_APP
EXPOSE $PORT

##ENTRYPOINT ["java", "-jar", "./msvc-usuarios-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT ["java", "-jar", "./target/msvc-usuarios-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]
#CMD sleep 20 && java -jar msvc-usuarios-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]
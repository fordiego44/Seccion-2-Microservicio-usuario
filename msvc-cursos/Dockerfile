#FROM openjdk:17.0.2
FROM openjdk:17-jdk-alpine as builder

#WORKDIR /app
WORKDIR /app/msvc-cursos


#COPY ./target/msvc-cursos-0.0.1-SNAPSHOT.jar .
COPY ./pom.xml /app
COPY ./msvc-cursos/.mvn ./.mvn
COPY ./msvc-cursos/mvnw .
COPY ./msvc-cursos/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./msvc-cursos/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/msvc-cursos/target/msvc-cursos-0.0.1-SNAPSHOT.jar .
EXPOSE 8001

##ENTRYPOINT ["java", "-jar", "./msvc-cursos-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT ["java", "-jar", "./target/msvc-cursos-0.0.1-SNAPSHOT.jar"]
#CMD sleep 10 && java -jar msvc-cursos-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "msvc-cursos-0.0.1-SNAPSHOT.jar"]
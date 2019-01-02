FROM openjdk:8
FROM gradle:5.0.0-jdk8
RUN ./gradlew clean build -x test
ADD build/libs/market-place-1.0.jar market-place-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "market-place-1.0.jar"]
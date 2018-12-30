FROM openjdk:8
ADD build/libs/market-place-1.0.jar market-place-1.0.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "market-place-1.0.jar"]
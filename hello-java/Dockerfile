FROM eclipse-temurin:17 as builder
WORKDIR app
COPY . .
RUN ./gradlew

FROM eclipse-temurin:17
WORKDIR app
COPY --from=builder app/build/libs/*.jar ./hello.jar
ENTRYPOINT ["java", "-cp", "hello.jar", "hello.HelloMain"]

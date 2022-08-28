FROM openjdk:8-jdk-slim
COPY "./target/TEST_NTT_DATA.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
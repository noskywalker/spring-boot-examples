FROM registry.cn-beijing.aliyuncs.com/xianshuangzhang/openjdk:8.8

ARG JAR_FILE

COPY ${JAR_FILE} ~/spring-boot-hello.jar

ENTRYPOINT ["java","-jar","~/spring-boot-hello.jar","--server.port=8080"]
 
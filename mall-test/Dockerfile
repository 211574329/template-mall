FROM registry.cn-beijing.aliyuncs.com/echo_r/jdk:1.8
MAINTAINER echo
ENV TZ=Asia/Shanghai
VOLUME /data/mall/test/
ADD mall-test/target/mall-test-1.0.jar mall-test.jar
EXPOSE 8025
RUN bash -c 'touch /mall-test.jar'
ENTRYPOINT ["java","-jar","mall-test.jar"]
#FROM jdk1.8:latest
# 设置作者信息
#MAINTAINER echo
#设置镜像的时区,避免出现8小时的误差
#ENV TZ=Asia/Shanghai
# 在主机 /data/dockerdata/ 目录下创建了一个临时文件，并链接到容器的/tmp
#VOLUME /data/dockerdata/
#ADD target/mall-test-1.0.jar mall-test.jar
# 设置端口号，此处只开放一个端口8011
#EXPOSE 8025
#RUN bash -c 'touch /mall-test.jar'
#ENTRYPOINT ["java","-jar","mall-test.jar"]
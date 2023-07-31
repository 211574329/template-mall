#FROM jdk1.8
FROM registry.cn-beijing.aliyuncs.com/echo_r/jdk:1.8
# 设置作者信息
MAINTAINER echo
#设置镜像的时区,避免出现8小时的误差
ENV TZ=Asia/Shanghai
# 在主机 /data/dockerdata/ 目录下创建了一个临时文件，并链接到容器的/tmp
#VOLUME /data/dockerdata/
# jar添加到容器里，并重命名为user.jar
ADD target/mall-user-1.0.jar mall-user.jar
# 设置端口号，此处只开放一个端口8011
#EXPOSE 8015
# 执行命令，此处运行user.jar
#RUN bash -c 'touch /mall-user.jar'
#ENTRYPOINT ["java","-jar","mall-user.jar"]
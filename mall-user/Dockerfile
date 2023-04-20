FROM jdk1.8:latest
# 设置作者信息
MAINTAINER echo
#设置镜像的时区,避免出现8小时的误差
ENV TZ=Asia/Shanghai
# 在主机 /data/dockerdata/ 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /data/dockerdata/
# jar添加到容器里，并重命名为user.jar
ADD mall-user-1.0.jar user.jar
# 设置端口号，此处只开放一个端口8010
EXPOSE 8010
# 执行命令，此处运行user.jar
RUN bash -c 'touch /user.jar'
ENTRYPOINT ["java","-jar","user.jar"]
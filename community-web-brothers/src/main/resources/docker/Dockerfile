FROM hub2.thinkinpower.com/jdk:8u65
VOLUME ["/data/logs/tomcat/community-web-brothers"]
WORKDIR /data/apps/webapps/community-web-brothers
COPY java2/community-web-brothers/target/community-web-brothers-webapp.jar  /data/apps/webapps/community-web-brothers
EXPOSE 10407
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/data/apps/webapps/community-web-brothers/community-web-brothers-webapp.jar"]
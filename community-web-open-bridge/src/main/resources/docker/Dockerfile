FROM hub2.thinkinpower.com/jdk
VOLUME ["/data/logs/tomcat/community-web-open-bridge"]
WORKDIR /data/apps/webapps/community-web-open-bridge
COPY java2/community-web-open-bridge/target/community-web-open-bridge-webapp.jar  /data/apps/webapps/community-web-open-bridge
EXPOSE 19402
ENTRYPOINT ["java","-Xmx256m","-Xms256m","-Djava.security.egd=file:/dev/./urandom","-jar","/data/apps/webapps/community-web-open-bridge/community-web-open-bridge-webapp.jar"]
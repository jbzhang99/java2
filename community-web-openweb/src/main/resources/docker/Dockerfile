FROM hub2.thinkinpower.com/jdk
VOLUME ["/data/logs/tomcat/community-web-openweb"]
WORKDIR /data/apps/webapps/community-web-openweb
COPY java2/community-web-openweb/target/community-web-openweb-webapp.jar  /data/apps/webapps/community-web-openweb
EXPOSE 10406
ENTRYPOINT ["java","-Xmx256m","-Xms256m","-Djava.security.egd=file:/dev/./urandom","-jar","/data/apps/webapps/community-web-openweb/community-web-openweb-webapp.jar"]
FROM hub2.thinkinpower.com/jdk
VOLUME ["/data/logs/tomcat/community-web-open-store"]
WORKDIR /data/apps/webapps/community-web-open-store
COPY java2/community-web-open-store/target/community-web-open-store-webapp.jar  /data/apps/webapps/community-web-open-store
EXPOSE 19403
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/data/apps/webapps/community-web-open-store/community-web-open-store-webapp.jar"]
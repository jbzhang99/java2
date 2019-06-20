FROM hub2.thinkinpower.com/jdk
VOLUME ["/data/logs/tomcat/application-community-openapi"]
WORKDIR /data/apps/webapps/application-community-openapi
COPY java2/community-web-openapi/target/community-web-openapi-webapp.jar  /data/apps/webapps/application-community-openapi
EXPOSE 10405
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/data/apps/webapps/application-community-openapi/community-web-openapi-webapp.jar"]
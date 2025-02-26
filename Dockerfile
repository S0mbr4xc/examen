FROM quay.io/wildfly/wildfly:30.0.1.Final-jdk17

ENV DEPLOYMENT_DIR /opt/jboss/wildfly/standalone/deployments/

COPY target/examen.war $DEPLOYMENT_DIR/examen.war

EXPOSE 8080 9990

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]


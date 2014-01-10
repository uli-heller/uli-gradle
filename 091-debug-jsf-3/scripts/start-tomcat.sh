#!/bin/sh
D="$(dirname "$0")"
DD="$(cd "${D}/.."; pwd)"

TOMCAT_HOME="$1"
#export CATALINA_OPTS="-javaagent:${DD}/lib/ext/springloaded-1.1.4.jar -noverify -XX:MaxPermSize=256m"
export CATALINA_OPTS="-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000"
export CATALINA_BASE="${DD}/catalina_base"

for subdir in logs conf temp webapps; do
  if [ ! -d "${CATALINA_BASE}/${subdir}" ]; then
    mkdir -p "${CATALINA_BASE}/${subdir}"
  fi
done

cp "${TOMCAT_HOME}/conf/"* "${CATALINA_BASE}/conf/."
#cp build/libs/*.war "${CATALINA_BASE}/webapps/."

exec "${TOMCAT_HOME}/bin/startup.sh"

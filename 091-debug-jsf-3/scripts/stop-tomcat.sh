#!/bin/sh
D="$(dirname "$0")"
DD="$(cd "${D}/.."; pwd)"

TOMCAT_HOME="$1"
export CATALINA_OPTS=""
export CATALINA_BASE="${DD}/catalina_base"

"${TOMCAT_HOME}/bin/shutdown.sh" 2>/dev/null
sleep 5
ps waux|grep "${TOMCAT_HOME}"|grep -v grep|cut -c10-15|xargs kill -9
exit 0

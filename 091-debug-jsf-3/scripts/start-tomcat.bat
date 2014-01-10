@echo off
set D=%~spd0

set TOMCAT_HOME=%1
set CATALINA_HOME=%1
::set CATALINA_OPTS=-javaagent:%D%../lib/ext/springloaded-1.1.4.jar -noverify -XX:MaxPermSize=256m
set CATALINA_OPTS=-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000
set CATALINA_BASE=%D%../catalina_base
"%CATALINA_HOME%\bin\startup.bat" 2>NUL

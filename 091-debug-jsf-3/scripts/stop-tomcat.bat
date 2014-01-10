@echo off

set CATALINA_HOME=%1
"%CATALINA_HOME%\bin\shutdown.bat" 2>NUL

Debugging a JSF Web Application
--------------------------------

*THIS IS OBSOLETE! CDI DOESN'T WORK!* 

* <http://stackoverflow.com/questions/2369987/why-are-managed-beans-not-loaded-in-tomcat>
* <http://stackoverflow.com/questions/12971961/managed-beans-not-instantiated-with-embedded-tomcat-7>

In this chapter, we debug a jsf application within eclipse. We don't use
a tomcat server embedded within eclipse.

Example: See [091-debug-jsf-2](091-debug-jsf-2).

* Start with an ordinary jsf web application project

    * `cp -a 090-jsf-webapp 091-debug-jsf-2`

* Extend the file [build.gradle](091-debug-jsf-2/build.gradle)

  ```
  apply plugin: "java"
  apply plugin: "war"
  apply plugin: "eclipse-wtp"

  dependencies {
    compile 'org.glassfish:javax.faces:2.2.+'
    compile 'org.apache.tomcat.embed:tomcat-embed-core:7.0.50'
  }

  repositories {
    mavenCentral()
  }
  ```

* Create the eclipse project

    * `gradlew eclipse`

* Start eclipse and import the project

* Create a starter class: src/main/java/org/uli/Main.java

* Within eclipse, create a new server

    * File - New - Other
    * Server - Server - Next
    * Apache - Tomcat v7.0 Server - Next
    * Tomcat installation directors: /opt/apache-tomcat-7.0.50 - Next
    * Add resource "091-debug-jsf-2" - Finish

* Within eclipse, debug the project

    * Run - Debug As - Debug on server

The embedded tomcat will be started and the embedded browser shows up opening
http://localhost:8080/091-debug-jsf-2/.

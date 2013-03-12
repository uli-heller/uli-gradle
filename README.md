ULI-GRADLE
==========

This git repo contains my gradle tutorials and some sample projects.

Gradle Coldstart
----------------

* Download the [gradle.zip](http://downloads.gradle.org/distributions/gradle-1.4-all.zip)

* Unzip it to a folder of your choice, for example $HOME/opt/gradle-1.4

* Add $HOME/opt/gradle-1.4/bin to the PATH environment variable

* Execute `gradle -v` and expect an output like this

  ```
  ------------------------------------------------------------
  Gradle 1.4
  ------------------------------------------------------------
  
  Gradle build time: Montag, 28. Januar 2013 03:42 Uhr UTC
  Groovy: 1.8.6
  Ant: Apache Ant(TM) version 1.8.4 compiled on May 22 2012
  Ivy: 2.2.0
  JVM: 1.6.0_27 (Sun Microsystems Inc. 20.0-b12)
  OS: Linux 3.5.0-25-generic amd64
  ```

Java Quickstart
---------------

* Create a java source file within src/main/java, for example
  src/main/java/org/uli/httpcat/HttpCat.java

* Create a gradle build file named build.gradle

  ```
  apply plugin: "java"
  ```

* Compile the java source file and create a jar file

  ```
  gradle jar
  ```

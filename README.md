ULI-GRADLE
==========

This git repo contains my gradle tutorials and some sample projects.

Overview
--------

* [Gradle Coldstart](#gradle-coldstart)
* [Java Quickstart](#java-quickstart)
* [Java Quickstart with Gradle Wrapper](#java-quickstart-with-gradle-wrapper)

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

Example: See [010-java-quickstart](010-java-quickstart). Note: You have
to install gradle first! See "Gradle Coldstart" for details!

* Create a java source file within src/main/java, for example
  src/main/java/org/uli/httpcat/HttpCat.java

* Create a gradle build file named build.gradle

  ```
  apply plugin: "java"
  ```

* Compile the java source file and create a jar file

  ```
  $ gradle jar
  :compileJava
  :processResources UP-TO-DATE
  :classes
  :jar
  
  BUILD SUCCESSFUL
  
  Total time: 2.917 secs
  ```

Java Quickstart With Gradle Wrapper
-----------------------------------

Example: See [020-java-quickstart-gradlew](020-java-quickstart-gradlew).
Note: You don't have to install gradle first!

* Assume you have a project with
    * a script named gradlew
    * a batch file named gradlew.bat
    * a folder named gradle

* Typically, there will be a build file named "build.gradle"

* Compile the java source file and create a jar file

  ```
  $ ./gradlew jar
  Downloading http://services.gradle.org/distributions/gradle-1.4-bin.zip
  ................................................
  .....................................................
  Unzipping .../.gradle/wrapper/dists/gradle-1.4-bin/.../gradle-1.4-bin.zip to .../.gradle/wrapper/dists/gradle-1.4-bin/...
  Set executable permissions for: .../.gradle/wrapper/dists/gradle-1.4-bin/.../gradle-1.4/bin/gradle
  :compileJava
  :processResources UP-TO-DATE
  :classes
  :jar
  
  BUILD SUCCESSFUL
  
  Total time: 2.917 secs
  ```

Avoiding Downloads With Gradle Wrapper
--------------------------------------

Example: See [020-java-quickstart-gradlew](020-java-quickstart-gradlew)
(same as before).

* If you use multiple PCs for development,
  gradle will be downloaded before starting the first build

  ```
  otherpc$ ./gradlew jar
  Downloading http://services.gradle.org/distributions/gradle-1.4-bin.zip
  ................................................^C
  otherpc$
  ```

* You can avoid this by copying the folder "$HOME/.gradle"

  ```
  thispc$ rsync -ruv "$HOME/.gradle" uli@otherpc:
  ```

  Note: Replace "otherpc" by the name of the other pc and "uli" by
  your username on the other pc!

* Now the build runs fine without a download

  ```
  otherpc$ ./gradlew jar
  :compileJava
  :processResources UP-TO-DATE
  :classes
  :jar
  
  BUILD SUCCESSFUL
  
  Total time: 2.933 secs
  ```

Gradle Wrapper
--------------

Example: See [030-gradle-wrapper](030-gradle-wrapper)
Within this chapter, we describe how to bootstrap the gradle wrapper.

* Starting point: The java quickstart project

* Add the Wrapper task to the gradle build file 

  ```
  apply plugin: "java"

  task wrapper(type: Wrapper) {
    gradleVersion = '1.4'
  }
  ```

* Execute the wrapper task

  ```
  $ gradle wrapper
  :wrapper

  BUILD SUCCESSFUL

  Total time: 3.62 secs
  ```

* Add the generated files to your version control system (subversion, git)

  ```
  $ git add -v gradle*
  add '02-gradle-wrapper/gradle/wrapper/gradle-wrapper.jar'
  add '02-gradle-wrapper/gradle/wrapper/gradle-wrapper.properties'
  add '02-gradle-wrapper/gradlew'
  add '02-gradle-wrapper/gradlew.bat'
  ```

* Run the build using gradle wrapper

  ```
  $ ./gradlew jar
  Downloading http://services.gradle.org/distributions/gradle-1.4-bin.zip
  ................................................
  .....................................................
  Unzipping .../.gradle/wrapper/dists/gradle-1.4-bin/.../gradle-1.4-bin.zip to .../.gradle/wrapper/dists/gradle-1.4-bin/...
  Set executable permissions for: .../.gradle/wrapper/dists/gradle-1.4-bin/.../gradle-1.4/bin/gradle
  :compileJava
  :processResources UP-TO-DATE
  :classes
  :jar
  
  BUILD SUCCESSFUL
  
  Total time: 5 mins 19.649 secs
  ```

Multi Project Build
-------------------

Example: See [041-multi-project](041-multi-project).

* Starting point: You have multiple separate projects

    * 010-java-quickstart

    * 020-java-quickstart-gradlew

    * 030-gradle-wrapper

* Create a new project: 041-multi-project

* Within the new project: Create the file settings.gradle

  ```
  include '010-java-quickstart',
          '020-java-quickstart-gradlew',
          '030-gradle-wrapper'
  ```

  Note: Don't use '../010-java-quickstart' or similar!
  With gradle-1.4 and 1.5-rc-2, this will lead to a failure 
  when executing `gradle jar`!

* Create links to the projects

    * `for i in 010 020 030; do ln -s ../$i*; done`

* Now execute the multi build

  ```
  $ gradle jar
  :010-java-quickstart:compileJava
  :010-java-quickstart:processResources UP-TO-DATE
  :010-java-quickstart:classes
  :010-java-quickstart:jar
  :020-java-quickstart-gradlew:compileJava
  :020-java-quickstart-gradlew:processResources UP-TO-DATE
  :020-java-quickstart-gradlew:classes
  :020-java-quickstart-gradlew:jar
  :030-gradle-wrapper:compileJava
  :030-gradle-wrapper:processResources UP-TO-DATE
  :030-gradle-wrapper:classes
  :030-gradle-wrapper:jar
  
  BUILD SUCCESSFUL
  
  Total time: 3.841 secs
  ```

External Dependencies
---------------------

Example: See [050-external-dependencies](050-external-dependencies).

* Starting point: A simple project based on gradle wrapper, for example
  [020-java-quickstart-gradlew](020-java-quickstart-gradlew).

* Try a build: `./gradlew check` -> "BUILD SUCCESSFUL"

* Add a java source file using an external dependency like this:
  [HtmlUnescape.java](050-external-dependencies/src/main/java/org/uli/htmlunescape/HtmlUnescape.java).

* Try a build: `./gradlew check` -> "BUILD FAILED"

* Determine artifactId, groupId, and version of the external dependency. In
  our case, this can be found on the [overview page](http://commons.apache.org/proper/commons-lang/index.html) of Apache Commons Lang.

    * artifactId: commons-lang3
    * groupId: org.apache.commons
    * version: 3.1

* Add the dependency to [build.gradle](050-external-dependencies/build.gradle)

  ```
  ...
  dependencies {
    compile group: 'org.apache.commons', name: 'commons-lang3', version: '3.1'
  }

  repositories {
    mavenCentral()
  }
  ```

* Try another build: `./gradlew check` -> "BUILD SUCCESSFUL"

Bundle An Application
---------------------

Example: See [052-application-bundling](052-application-bundling).


You'd like to build an application consisting of

* your java classes

* the external dependencies

* a start script

There is a gradle plugin which helps you doing this.

* Starting point: A project with external dependencies, for example
  a copy of [050-external-dependencies](050-external-dependencies).

* Modify the file [build.gradle](052-application-bundling/build.gradle): Add
  the application plugin and define the main class.

* Create a file [settings.gradle](052-application-bundling/settings.gradle):
  Define the project name.

* Run the build: `./gradlew installApp`

* Run the application:
  `./build/install/html-unescape/bin/html-unescape -f data/test-data.txt -t data/test-data.out`

* Delete the generated file (after looking at it):
  `rm -f data/test-data.out`

Integration Into Eclipse
------------------------

Example: See [060-eclipse-integration](060-eclipse-integration).

* Start with a copy of a gradle project, for example create a copy
  of [050-external-dependencies](050-external-dependencies).

* Modify the file [build.gradle](060-eclipse-integration/build.gradle):
  Add the eclipse plugin.

  ```
  ...
  apply plugin: 'eclipse'
  ...
  ```

* Execute `./gradlew eclipse`

* Now you can import the project into eclipse

    * File - Import

    * General - Existing Projects into Workspace - Next

    * Select root directory: .../060-eclipse-integration

    * Finish

Note: The eclipse project files to contain absolut paths to your working
environment, so you will probably never store them in a version control
system.

Devloping a Web Application
---------------------------

Example: See [070-webapp](070-webapp).

* Copy some files from another project

    * `cd 070-webapp`
    * `cp ../020-java-quickstart-gradlew/gradle* .`

* Create the file [build.gradle](070-webapp/build.gradle)

  ```
  apply plugin: "java"
  apply plugin: "war"
  ```

* Create the webapp folder: `mkdir -p src/main/webapp/WEB-INF`

* Create a welcome file [src/main/webapp/index.html](070-webapp/src/main/webapp/index.html)

* Create the file [src/main/webapp/WEB-INF/web.xml](070-webapp/src/main/webapp/WEB-INF/web.xml)

* Generate the war file: `./gradlew assemble`

* Deploy the war file into Tomcat7: 
  `cp build/libs/070-webapp.war /opt/apache-tomcat-7.0.37/webapps`

  Note: This assumes that your Tomcat7 installation resides in
  /opt/apache-tomcat-7.0.37.

* Start Tomcat7:
  `/opt/apache-tomcat-7.0.37/bin/startup.sh`

* Navigate your browser to [http://localhost:8080/070-webapp/](http://localhost:8080/070-webapp/)

  Note: This assumes that your Tomcat7 listens to port 8080, which is the
  default setting.

Groovy Quickstart
-----------------

Example: See [200-groovy-quickstart](200-groovy-quickstart). Note: You have

* Create a groovy source file within src/main/groovy, for example
  src/main/groovy/org/uli/linesep/LineSep.groovy

* Create a gradle build file named build.gradle

  ```
  apply plugin: "groovy"
  repositories {
    mavenCentral()
  }
  dependencies {
    compile 'org.codehaus.groovy:groovy-all:2.1.1'
  }
  ```

* Compile the groovy source file and create a jar file

  ```
  $ gradle jar
  Download http://repo1.maven.org/.../2.1.1/groovy-all-2.1.1.pom
  Download http://repo1.maven.org/.../2.1.1/groovy-all-2.1.1.jar
  :compileJava UP-TO-DATE
  :compileGroovy
  :processResources UP-TO-DATE
  :classes
  :jar
  
  BUILD SUCCESSFUL
  
  Total time: 3.691 secs
  ```

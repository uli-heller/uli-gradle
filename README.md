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

Example: See [01-java-quickstart](01-java-quickstart). Note: You have
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

Example: See [02-java-quickstart-gradlew](02-java-quickstart-gradlew).
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

Gradle Wrapper
--------------

Example: See [03-gradle-wrapper](03-gradle-wrapper)
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

Example: See [04-multi-project](04-multi-project).

* Starting point: You have multiple separate projects

    * 01-java-quickstart

    * 02-java-quickstart-gradlew

    * 03-gradle-wrapper

* Create a new project: 04-multi-project

* Within the new project: Create the file settings.gradle

  ```
  include '../01-java-quickstart',
          '../02-java-quickstart-gradlew',
          '../03-gradle-wrapper'
  ```

* Now execute the multi build

  ```
  $ gradle check
  :../01-java-quickstart:compileJava
  :../01-java-quickstart:processResources UP-TO-DATE
  :../01-java-quickstart:classes
  :../01-java-quickstart:compileTestJava UP-TO-DATE
  ...
  :../03-gradle-wrapper:testClasses UP-TO-DATE
  :../03-gradle-wrapper:test
  :../03-gradle-wrapper:check
  
  BUILD SUCCESSFUL
  
  Total time: 3.59 secs
  ```

* Note: With gradle-1.4 and 1.5-rc-1, executing `gradle jar` fails

External Dependencies
---------------------

Example: See [05-external-dependencies](05-external-dependencies).

* Starting point: A simple project based on gradle wrapper, for example
  [02-java-quickstart-gradlew](02-java-quickstart-gradlew).

* Try a build: `./gradlew check` -> "BUILD SUCCESSFUL"

* Add a java source file using an external dependency like this:
  [HtmlUnescape.java](05-external-dependencies/src/main/java/org/uli/htmlunescape/HtmlUnescape.java).

* Try a build: `./gradlew check` -> "BUILD FAILED"

* Determine artifactId, groupId, and version of the external dependency. In
  our case, this can be found on the [overview page](http://commons.apache.org/proper/commons-lang/index.html) of Apache Commons Lang.

    * artifactId: commons-lang3
    * groupId: org.apache.commons
    * version: 3.1

* Add the dependency to [build.gradle](05-external-dependencies/build.gradle)

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

Groovy Quickstart
-----------------

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

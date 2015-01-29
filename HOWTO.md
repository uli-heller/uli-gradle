HOWTOs For My Gradle Project
============================

Switch To Another Gradle Version
--------------------------------

For example from 1.12 to 2.2.1. Attention: This doesn't work when other dependencies use a similar or the same version number!

* Cleanup: `for i in */gradlew; do (cd $(dirname $i); ./gradlew clean); done`
* Determine the currently used version: 1.12
* Find all usage of this version number:
    * `find . -type f|xargs grep -l "1.12"` ... gets a list of files
    * `find . -type f|xargs grep "1.12"` ... gets the lines containing the version
* Search and replace: `find . -type f|grep "gradle-wrapper.properties\|-wrapper/build.gradle"|xargs grep -l "1.12"|xargs -n1 sed -i "s/1.12/2.2.1/"`
* Cleanup again: `for i in */gradlew; do (cd $(dirname $i); ./gradlew clean); done`
* Build all jars: `for i in */gradlew; do (cd $(dirname $i); ./gradlew jar); done`
* Commit: `git commit -m "Upgraded gradle: 1.12 -> 2.2.1" .`

As of 2015-01-29, these files are affected:

```
 M 020-java-quickstart-gradlew/gradle/wrapper/gradle-wrapper.properties
 M 030-gradle-wrapper/build.gradle
 M 030-gradle-wrapper/gradle/wrapper/gradle-wrapper.properties
 M 050-external-dependencies/gradle/wrapper/gradle-wrapper.properties
 M 0501-guava/gradle/wrapper/gradle-wrapper.properties
 M 051-proxy/gradle/wrapper/gradle-wrapper.properties
 M 052-application-bundling/gradle/wrapper/gradle-wrapper.properties
 M 055-junit/gradle/wrapper/gradle-wrapper.properties
 M 057-findbugs/gradle/wrapper/gradle-wrapper.properties
 M 060-creating-eclipse-projects/gradle/wrapper/gradle-wrapper.properties
 M 085-webapp/gradle/wrapper/gradle-wrapper.properties
 M 090-jsf-webapp/gradle/wrapper/gradle-wrapper.properties
 M 091-debug-jsf-2/gradle/wrapper/gradle-wrapper.properties
 M 091-debug-jsf-3/gradle/wrapper/gradle-wrapper.properties
 M 091-debug-jsf/gradle/wrapper/gradle-wrapper.properties
 M 092-javamelody/gradle/wrapper/gradle-wrapper.properties
 M 100-jpa-hibernate/gradle/wrapper/gradle-wrapper.properties
 M 102-jpa-eclipselink/gradle/wrapper/gradle-wrapper.properties
 M 120-markdown/gradle/wrapper/gradle-wrapper.properties
 M 120-markdown/settings.gradle
 M 99x-jar-collector/gradle/wrapper/gradle-wrapper.properties
 M README.md
```

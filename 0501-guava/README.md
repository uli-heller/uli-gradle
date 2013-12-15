Using Google Guava With Gradle
==============================

At one of my customers, we do have issues with a gradle build
of a project which uses Google Guava. I've created this mini project
and ran the build at home - no issues.

Next, I'll take the project and run it at the customer.

Direct Internet Access At Home
------------------------------

    0501-guava$ rm -rf $(pwd)/gh
    0501-guava$ rm -f  gradle.properties
    0501-guava$ ./gradlew -g $(pwd)/gh clean assemble
    :clean
    :compileJava
    Download http://repo1.maven.org/maven2/com/google/guava/guava/15.0/guava-15.0.pom
    Download http://repo1.maven.org/maven2/com/google/guava/guava-parent/15.0/guava-parent-15.0.pom
    Download http://repo1.maven.org/maven2/com/google/guava/guava/15.0/guava-15.0.jar
    :processResources UP-TO-DATE
    :classes
    :jar
    :assemble
    
    BUILD SUCCESSFUL
    
    Total time: 7.299 secs

Internet Access Via Proxy At Home
---------------------------------

    0501-guava$ rm -rf $(pwd)/gh
    0501-guava$ mv gradle.properties.use-proxy gradle.properties
    0501-guava$ ./gradlew -g $(pwd)/gh clean assemble
    :clean UP-TO-DATE
    :compileJava
    Download http://repo1.maven.org/maven2/com/google/guava/guava/15.0/guava-15.0.pom
    Download http://repo1.maven.org/maven2/com/google/guava/guava-parent/15.0/guava-parent-15.0.pom
    Download http://repo1.maven.org/maven2/com/google/guava/guava/15.0/guava-15.0.jar
    :processResources UP-TO-DATE
    :classes
    :jar
    :assemble
    
    BUILD SUCCESSFUL
    
    Total time: 6.34 secs

### forward-proxy.log

Looking at the log file of the proxy server shows access to these URLs:

* GET /maven2/com/google/guava/guava/15.0/guava-15.0.pom HTTP/1.1
* GET /maven2/com/google/guava/guava-parent/15.0/guava-parent-15.0.pom HTTP/1.1
* HEAD /maven2/org/sonatype/oss/oss-parent/7/oss-parent-7.pom HTTP/1.1
* GET /maven2/org/sonatype/oss/oss-parent/7/oss-parent-7.pom.sha1 HTTP/1.1
* HEAD /maven2/org/sonatype/oss/oss-parent/7/oss-parent-7.jar HTTP/1.1
* HEAD /maven2/com/google/guava/guava-parent/15.0/guava-parent-15.0.jar HTTP/1.1
* GET /maven2/com/google/guava/guava/15.0/guava-15.0.jar HTTP/1.1

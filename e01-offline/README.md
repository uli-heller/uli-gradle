This project illustrates an issue related to the option "--offline"
of gradlew:

* `./gradlew jar` executes without a deprecation warning
* `./gradlew --offline jar` shows this warning:

      <pre>Attempting to change configuration ':util:compile' after it has been included in dependency resolution. This behaviour has been deprecated and is scheduled to be removed in Gradle 3.0</pre>

The project doesn't contain anything useful aside from showing the error,
even the build files aren't useful.

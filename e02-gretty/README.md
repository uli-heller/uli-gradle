# Gretty And Logging

## [The Issue](https://github.com/akhikhl/gretty/issues/145)

Basically, I'd like to start a webapp with gretty and use logging
within the webapp. It is expected to work out of the box.

Unfortunately, for all known gretty versions, you have to add
some exception rules to your build.gradle file to make this work
(suggested by [akhikl](https://github.com/akhikhl)):

```
  configurations {
    grettyRunnerTomcat7 {
      exclude group: 'org.slf4j', module: 'log4j-over-slf4j'
    }
  }
```

From time to time, I'm using this project to verify
newer versions of gretty related to the issue.

## Run And Check

This small project checks for the logging within
a tomcat started by gretty. It is related to [issue 145](https://github.com/akhikhl/gretty/issues/145).

You start the tomcat like this:

```
# Execute this in a terminal/command window
gradle appRun
```

The open [this link](http://localhost:8080/e02-gretty/do/list)
within your browser.

The expected display looks like this:

```
pathInfo=/list

org.uli.e02gretty.E02GrettyServlet	DEBUG
```

The issue ... leads to this:

```
PathInfo=/list

No loggers
```

## Gretty Versions

* 1.1.9: [issue 145](https://github.com/akhikhl/gretty/issues/145) exists
* 1.2.0: [issue 145](https://github.com/akhikhl/gretty/issues/145) exists
* 1.2.1: [issue 145](https://github.com/akhikhl/gretty/issues/145) exists
* 1.2.2: [issue 145](https://github.com/akhikhl/gretty/issues/145) exists
* 1.2.3: [issue 145](https://github.com/akhikhl/gretty/issues/145) exists

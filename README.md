Orbit Carnival Scala
=====
Sample EA Orbit app built with Scala

# Run

## Start orbit server
```sh
docker run -it -p 50056:50056 orbitframework/orbit:2.0.0-alpha.102
```

## Start sample app

Build fatjar
```sh
gradle clean fatJar
```

Run
```sh
java -jar build/libs/orbit-carnival-scala-release.jar
```

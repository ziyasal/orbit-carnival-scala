Orbit Carnival Scala
=====
Sample EA Orbit app built with Scala & Finagle

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

Result
```sh
❯ curl -D - localhost:8080

HTTP/1.1 200 OK
Content-Length: 104

You said: 'Welcome to Orbit',I say: 'Hello from StringKey(key=Bug the system) at node 3d1jUlab8HDyd9fN!'
```
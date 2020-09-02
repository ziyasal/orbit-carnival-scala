val grpcVersion by extra("1.28.1")
val slf4jVersion by extra("1.7.28")
val jacksonVersion by extra("2.10.3")

plugins {
    val kotlinVersion = "1.4.0"

    base
    kotlin("jvm") version kotlinVersion
    scala
    `java-library`
}

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://maven.pkg.github.com") }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.3.5")

    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("cloud.orbit:orbit-client:2.0.0-alpha.102")

    implementation("io.grpc:grpc-netty-shaded:$grpcVersion")
    implementation("io.grpc:grpc-protobuf:$grpcVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    implementation("org.scala-lang:scala-library:2.13.2")

    testImplementation("junit:junit:null")
    testImplementation("org.scalatest:scalatest_2.13:3.1.2")
    testImplementation("org.scalatestplus:junit-4-12_2.13:3.1.2.0")

    // Need scala-xml at test runtime
    testRuntimeOnly("org.scala-lang.modules:scala-xml_2.13:1.2.0")
}
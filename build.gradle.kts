plugins {
    kotlin("jvm") version "2.0.0-Beta5"
}

group = "com.druid.client"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-webflux:6.1.5")
}

kotlin {
    jvmToolchain(JavaVersion.VERSION_17.majorVersion.toInt())
}

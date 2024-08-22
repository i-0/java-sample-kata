plugins {
  id("java")
}

group = "org.i0.tryouts"

version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  gradlePluginPortal()
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:5.9.1"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks.test { useJUnitPlatform() }

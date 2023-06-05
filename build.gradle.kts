plugins {
  id("java")
  id("com.diffplug.spotless") version "6.19.0"
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
}

tasks.test { useJUnitPlatform() }

spotless {
  format("misc") {
    target("**/*.md", "**/*.xml", "**/*.yml", "**/*.yaml", ".gitignore", "**/*.sh")
    targetExclude("**/build/**/*", "**/.idea/**")
    trimTrailingWhitespace()
    endWithNewline()
    indentWithSpaces(2)
  }

  java {
    target("**/*.java")
    targetExclude("**/build/**/*.java")
    googleJavaFormat().reflowLongStrings()
    removeUnusedImports()
    indentWithSpaces(2)
  }

  kotlin {
    target("**/src/**/*.kt", "**/src/**/*.kts", "**/buildSrc/**/*.kts")
    targetExclude("**/build/**/*.kts", "**/build/**/*.kt")
    ktfmt().googleStyle()
    indentWithSpaces(2)
  }

  kotlinGradle {
    target("**/*.gradle.kts")
    targetExclude("**/build/**/*.gradle.kts")
    ktfmt().googleStyle()
  }

  freshmark { target("*.md") }
}

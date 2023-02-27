plugins {
  id("java")
  id("org.jetbrains.intellij") version "1.10.1"
}

group = "com.github.peco2282"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  mavenLocal()
  gradlePluginPortal()
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
  version.set("2022.3.2")
  //AI, CL, GW, GO, IC, IU, PS, PY, PC, RD
  type.set("IU") // Target IDE Platform

  plugins.set(listOf(/* Plugin Dependencies */))
}
tasks {
  // Set the JVM compatibility versions
  withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
  }

  patchPluginXml {
    sinceBuild.set("221")
    untilBuild.set("231.*")
  }

  signPlugin {
    certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
    privateKey.set(System.getenv("PRIVATE_KEY"))
    password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
  }

  publishPlugin {
    token.set(System.getenv("PUBLISH_TOKEN"))
  }
}

plugins {
    // The Kotlin DSL plugin provides a convenient way to develop convention plugins.
    // Convention plugins are located in `src/main/kotlin`, with the file extension `.gradle.kts`,
    // and are applied in the project's `build.gradle.kts` files as required.
    `kotlin-dsl`
}

kotlin {
    jvmToolchain(21)
}

repositories {
    gradlePluginPortal()
    maven { url = uri("https://repo.jenkins-ci.org/public") } // Jenkins artifacts
}

dependencies {
    // Add a dependency on the Kotlin Gradle plugin, so that convention plugins can apply it.
    implementation(libs.kotlinGradlePlugin)
    implementation("org.jenkins-ci.tools:gradle-jpi-plugin:0.52.0") // Downgrade
}

gradlePlugin {
    plugins {
        create("jenkinsPluginConvention") {
            id = "jenkins-plugin-poc"
            implementationClass = "buildsrc.convention.JenkinsPluginConvention"
        }
    }
}

package buildsrc.convention

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.jenkinsci.gradle.plugins.jpi.JpiPlugin
import org.gradle.jvm.toolchain.JavaLanguageVersion

class JenkinsPluginConvention : Plugin<Project> {
    override fun apply(project: Project) {

        // reusing the already available gradle-jpi-plugin
        project.plugins.apply(JpiPlugin::class.java)

        // custom settings for my new plugin
        project.extensions.configure<org.jenkinsci.gradle.plugins.jpi.JpiExtension> {
            jenkinsVersion.set("2.440.3")
            displayName = "Aarav Mahajan Plugin"
            shortName = "am-plugin"
            extension.set("hpi")
        }

        project.configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
            
            // Configure Java toolchain to use Java 21 for compilation and execution
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(21))
            }
        }
    }
}
plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:7.2.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
    implementation("com.google.gms:google-services:4.3.10")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:10.2.0")
}

gradlePlugin {
    plugins {
        register("common-module-plugin") {
            id = "common-module-plugin"
            implementationClass = "CommonModulePlugin"
        }
    }
}
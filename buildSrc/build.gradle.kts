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
    implementation("com.android.tools.build:gradle:7.0.0-beta02")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
    implementation("com.google.gms:google-services:4.3.8")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:10.0.0")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.35.1")
}

gradlePlugin {
    plugins {
        register("common-module-plugin") {
            id = "common-module-plugin"
            implementationClass = "CommonModulePlugin"
        }
    }
}
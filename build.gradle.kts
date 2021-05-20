buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ProjectDependencies.agp)
        classpath(ProjectDependencies.kotlinGradlePlugin)
        classpath(ProjectDependencies.googleMobileServices)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks {
    val clean: TaskProvider<Delete> by registering(Delete::class) {
        println("Started cleaning")
        delete(buildDir)
        println("Done")
    }
}
buildscript {
    repositories {
        google()
        mavenCentral()
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
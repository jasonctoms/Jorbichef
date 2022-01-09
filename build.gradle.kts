buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
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
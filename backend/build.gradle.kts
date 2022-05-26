plugins {
    id("com.android.library")
    id("common-module-plugin")
    kotlin("plugin.serialization") version Versions.kotlinSerialization
}

kotlin.sourceSets.all {
    languageSettings.optIn("kotlin.RequiresOptIn")
}

dependencies {
    implementation(Dependencies.room)
    implementation(Dependencies.roomRuntime)
    kapt(Dependencies.roomCompiler)

    implementation(platform(Dependencies.firebaseBom))
    implementation(Dependencies.firebaseFirestore)
    implementation(Dependencies.firebaseStorage)
    implementation(Dependencies.firebaseAuth)
    implementation(Dependencies.coroutinesPlayServices)

    implementation(Dependencies.kotlinSerializationJson)
}
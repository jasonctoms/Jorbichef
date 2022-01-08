plugins {
    id("com.android.library")
    id("common-module-plugin")
}

dependencies {
    implementation(Dependencies.roomRuntime)
    annotationProcessor(Dependencies.roomCompiler)

    implementation(platform(Dependencies.firebaseBom))
    implementation(Dependencies.firebaseFirestore)
    implementation(Dependencies.firebaseAuth)
    implementation(Dependencies.coroutinesPlayServices)
}
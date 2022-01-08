plugins {
    id("com.android.library")
    id("common-module-plugin")
}

dependencies {
    implementation(Dependencies.roomRuntime)
    annotationProcessor(Dependencies.roomCompiler)
}
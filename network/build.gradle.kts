plugins {
    id("com.android.library")
    id("common-module-plugin")
    id("com.apollographql.apollo").version(Versions.apollo)
}

apollo {
    generateKotlinModels.set(true)
}

dependencies {
    implementation(Dependencies.apolloRuntime)
    implementation(Dependencies.apolloCoroutines)
}
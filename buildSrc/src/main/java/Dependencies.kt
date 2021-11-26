object Versions {
    const val compose = "1.0.5"
    const val navigationCompose = "2.4.0-beta02"
    const val hiltNavigationCompose = "1.0.0-beta01"

    const val firebaseBom = "29.0.0"
    const val firebaseUiAuth = "7.2.0"

    // AndroidX
    const val coreKtx = "1.7.0"
    const val appCompat = "1.4.0"
    const val material = "1.3.0"
    const val lifecycle = "2.4.0"
    const val hilt = "2.40.2"

    const val apollo = "2.5.7"
}

object TestVersions {
    const val espresso = "3.3.0"
    const val androidXJUnit = "1.1.2"
    const val jUnit4 = "4.13.2"
}

object Dependencies {
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeMaterialIcons = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx"
    const val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx"
    const val firebaseUiAuth = "com.firebaseui:firebase-ui-auth:${Versions.firebaseUiAuth}"

    const val apolloRuntime = "com.apollographql.apollo:apollo-runtime:${Versions.apollo}"
    const val apolloCoroutines = "com.apollographql.apollo:apollo-coroutines-support:${Versions.apollo}"
}

object TestDependencies {
    const val jUnit4 = "junit:junit:${TestVersions.jUnit4}"
    const val androidXJUnit = "androidx.test.ext:junit:${TestVersions.androidXJUnit}"
    const val espresso = "androidx.test.espresso:espresso-core:${TestVersions.espresso}"
}

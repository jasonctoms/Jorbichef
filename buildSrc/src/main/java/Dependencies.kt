object Versions {
    // Compose
    const val compose = "1.1.0-rc01"
    const val navigationCompose = "2.4.0-rc01"
    const val composeMaterial3 = "1.0.0-alpha02"

    // Firebase
    const val firebaseBom = "29.0.3"
    const val firebaseUiAuth = "8.0.0"

    // AndroidX
    const val coreKtx = "1.7.0"
    const val appCompat = "1.4.0"
    const val material = "1.3.0"
    const val lifecycle = "2.4.0"
    const val roomVersion = "2.4.0"

    // Koin
    const val koin = "3.1.4"

    const val timber = "5.0.1"

    const val coroutinesPlayServices = "1.6.0"
}

object TestVersions {
    const val espresso = "3.3.0"
    const val androidXJUnit = "1.1.2"
    const val jUnit4 = "4.13.2"
}

object Dependencies {
    // Compose
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeMaterialIcons = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"

    // Firebase
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx"
    const val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx"
    const val firebaseUiAuth = "com.firebaseui:firebase-ui-auth:${Versions.firebaseUiAuth}"

    // AndroidX
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"

    // Koin
    const val koin = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val coroutinesPlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutinesPlayServices}"
}

object TestDependencies {
    const val jUnit4 = "junit:junit:${TestVersions.jUnit4}"
    const val androidXJUnit = "androidx.test.ext:junit:${TestVersions.androidXJUnit}"
    const val espresso = "androidx.test.espresso:espresso-core:${TestVersions.espresso}"
}

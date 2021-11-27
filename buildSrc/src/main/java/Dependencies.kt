object Versions {
    const val compose = "1.1.0-beta03"
    const val navigationCompose = "2.4.0-beta02"
    const val composeMaterial3 = "1.0.0-alpha01"

    const val firebaseBom = "29.0.0"
    const val firebaseUiAuth = "7.2.0"

    // AndroidX
    const val coreKtx = "1.7.0"
    const val appCompat = "1.4.0"
    const val material = "1.3.0"
    const val lifecycle = "2.4.0"

    const val koin = "3.1.4"
}

object TestVersions {
    const val espresso = "3.3.0"
    const val androidXJUnit = "1.1.2"
    const val jUnit4 = "4.13.2"
}

object Dependencies {
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeMaterialIcons = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx"
    const val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx"
    const val firebaseUiAuth = "com.firebaseui:firebase-ui-auth:${Versions.firebaseUiAuth}"

    const val koin = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
}

object TestDependencies {
    const val jUnit4 = "junit:junit:${TestVersions.jUnit4}"
    const val androidXJUnit = "androidx.test.ext:junit:${TestVersions.androidXJUnit}"
    const val espresso = "androidx.test.espresso:espresso-core:${TestVersions.espresso}"
}

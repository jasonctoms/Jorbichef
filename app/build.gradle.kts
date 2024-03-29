plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("common-module-plugin")
}

android {
    defaultConfig {
        applicationId = AndroidConfig.applicationId
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(project(":design"))
    implementation(project(":backend"))

    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial3)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeMaterialIcons)
    implementation(Dependencies.composeLiveData)
    implementation(Dependencies.navigationCompose)

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.lifecycle)

    implementation(Dependencies.coil)
    implementation(Dependencies.coilCompose)

    implementation(platform(Dependencies.firebaseBom))
    implementation(Dependencies.firebaseAnalytics)
    implementation(Dependencies.firebaseAuth)
    implementation(Dependencies.firebaseUiAuth)
}

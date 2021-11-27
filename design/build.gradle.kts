plugins {
    id("com.android.library")
    id("common-module-plugin")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial3)

    implementation(Dependencies.material)
}

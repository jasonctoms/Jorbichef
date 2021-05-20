plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
}

android {
    compileSdk = AndroidConfig.compile
    buildToolsVersion = AndroidConfig.buildToolsVersions

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.min
        targetSdk = AndroidConfig.target
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = AndroidConfig.testInstrumentationRunner

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Compatibility.source
        targetCompatibility = Compatibility.target
    }
    kotlinOptions {
        jvmTarget = Compatibility.target.toString()
        useIR = true
    }
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
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeMaterialIcons)
    implementation(Dependencies.composeLiveData)
    implementation(Dependencies.navigationCompose)

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.lifecycle)

    implementation(platform(Dependencies.firebaseBom))
    implementation(Dependencies.firebaseAnalytics)

    testImplementation(TestDependencies.jUnit4)
    androidTestImplementation(TestDependencies.androidXJUnit)
    androidTestImplementation(TestDependencies.espresso)
}
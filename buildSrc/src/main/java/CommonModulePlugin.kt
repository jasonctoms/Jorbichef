import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class CommonModulePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply("kotlin-android")
        project.plugins.apply("org.jlleitschuh.gradle.ktlint")
        project.plugins.apply("dagger.hilt.android.plugin")
        project.plugins.apply("org.jetbrains.kotlin.kapt")

        //Android block
        val androidExtensions = project.extensions.getByName("android")
        if (androidExtensions is BaseExtension) {
            androidExtensions.configureAndroid(project)
        }
        project.configureDependencies()
    }

    private fun BaseExtension.configureAndroid(project: Project) = run {
        compileSdkVersion(AndroidConfig.compile)
        buildToolsVersion = AndroidConfig.buildToolsVersion
        defaultConfig {
            minSdk = AndroidConfig.min
            targetSdk = AndroidConfig.target

            testInstrumentationRunner = AndroidConfig.testInstrumentationRunner

        }
        compileOptions {
            sourceCompatibility = Compatibility.source
            targetCompatibility = Compatibility.target
        }
        project.tasks.withType(KotlinCompile::class.java).configureEach {
            kotlinOptions.apply {
                jvmTarget = Compatibility.target.toString()
                freeCompilerArgs += Compatibility.enableIR
            }
        }
        testOptions {
            unitTests.isReturnDefaultValues = true
        }
        when (this) {
            is LibraryExtension -> {
                defaultConfig {
                    // apply the pro guard rules for library
                    consumerProguardFiles("consumer-rules.pro")
                }
            }

            is ApplicationExtension -> {
                buildTypes {
                    getByName("release") {
                        isMinifyEnabled = false
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                    }
                }
            }
        }
    }

    private fun Project.configureDependencies() = dependencies.apply {
        add("implementation", Dependencies.hilt)
        add("kapt", Dependencies.hiltCompiler)
        add("testImplementation", TestDependencies.jUnit4)
        add("androidTestImplementation", TestDependencies.androidXJUnit)
        add("androidTestImplementation", TestDependencies.espresso)
    }
}
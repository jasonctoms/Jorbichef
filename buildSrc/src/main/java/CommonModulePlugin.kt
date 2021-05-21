import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class CommonModulePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply("kotlin-android")

        //Android block
        val androidExtensions = project.extensions.getByName("android")
        if (androidExtensions is BaseExtension) {
            androidExtensions.configureAndroid()
        }
        project.configureDependencies()
    }

    private fun BaseExtension.configureAndroid() = run {
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
        add("testImplementation", TestDependencies.jUnit4)
        add("androidTestImplementation", TestDependencies.androidXJUnit)
        add("androidTestImplementation", TestDependencies.espresso)
    }
}
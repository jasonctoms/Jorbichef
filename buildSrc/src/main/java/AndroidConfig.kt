import org.gradle.api.JavaVersion

object AndroidConfig {
    const val min = 26
    const val compile = 30
    const val target = compile
    const val buildToolsVersion = "30.0.3"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val applicationId = "com.jorbital.jorbichef"
    const val versionCode = 1
    const val versionName = "1.0"
}

object Compatibility {
    val source = JavaVersion.VERSION_1_8
    val target = JavaVersion.VERSION_1_8
    const val enableIR = "-Xallow-jvm-ir-dependencies"
}

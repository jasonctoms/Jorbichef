import org.gradle.api.JavaVersion

object AndroidConfig {
    const val min = 26
    const val compile = 31
    const val target = compile
    const val buildToolsVersion = "31.0.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val applicationId = "com.jorbital.jorbichef"
    const val versionCode = 1
    const val versionName = "1.0"
}

object Compatibility {
    val source = JavaVersion.VERSION_1_8
    val target = JavaVersion.VERSION_1_8
}

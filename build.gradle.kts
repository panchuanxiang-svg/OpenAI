val versionCode by extra(100)
val versionName by extra("3.0.0-android-only")

val compileSdk by extra(35)
val targetSdk by extra(35)
val minSdk by extra(26)

val javaVersionEnum by extra(JavaVersion.VERSION_21)

val groupName by extra("com.samsung.firmware")
val packageName by extra("com.samsung.firmware.downloader")
val appName by extra("Samsung Firmware Downloader")

val bugsnagAndroidApiKey by extra("3e0ed592029da1d5cc9b52160ef702ea")

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.bugsnag.gradle) apply false
    alias(libs.plugins.buildkonfig) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.serialization) apply false
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.addAll("-Xskip-prerelease-check", "-Xdont-warn-on-error-suppression")
    }
}

group = groupName
version = versionName

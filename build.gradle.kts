val versionCode by extra(93)
val versionName by extra("2.1.2")

val compileSdk by extra(37)
val targetSdk by extra(36)
val minSdk by extra(26)

val javaVersionEnum by extra(JavaVersion.VERSION_21)

val groupName by extra("tk.zwander")
val packageName by extra("tk.zwander.samsungfirmwaredownloader")
val appName by extra("Bifrost")

val bugsnagAndroidApiKey by extra("3e0ed592029da1d5cc9b52160ef702ea")

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.bugsnag.gradle) apply false
    alias(libs.plugins.buildkonfig) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.kotlin.atomicfu) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.moko.resources) apply false
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.addAll("-Xskip-prerelease-check", "-Xdont-warn-on-error-suppression")
    }
}

group = groupName
version = versionName

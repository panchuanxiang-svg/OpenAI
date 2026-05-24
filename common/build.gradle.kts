import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.bugsnag.gradle)
    alias(libs.plugins.buildkonfig)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
}

group = rootProject.extra["groupName"].toString()
version = rootProject.extra["versionName"].toString()

android {
    val compileSdk: Int by rootProject.extra
    val minSdk: Int by rootProject.extra

    this.compileSdk = compileSdk

    defaultConfig {
        this.minSdk = minSdk
    }

    namespace = "com.samsung.firmware.common"

    buildFeatures {
        compose = true
    }

    compileOptions {
        val javaVersionEnum: JavaVersion by rootProject.extra
        sourceCompatibility = javaVersionEnum
        targetCompatibility = javaVersionEnum
        isCoreLibraryDesugaringEnabled = true
    }

    lint {
        abortOnError = false
    }
}

dependencies {
    // Compose
    api(libs.compose.foundation)
    api(libs.compose.material3)
    api(libs.compose.runtime)
    api(libs.compose.ui)
    api(libs.material.icons.core)
    
    // Kotlin
    api(libs.kotlin)
    api(libs.kotlin.reflect)
    api(libs.kotlinx.coroutines)
    api(libs.kotlinx.coroutines.android)
    api(libs.kotlinx.datetime)
    api(libs.kotlinx.io.core)
    api(libs.kotlinx.serialization.json)
    
    // Networking
    api(libs.ktor.client.auth)
    api(libs.ktor.client.core)
    api(libs.ktor.client.okhttp)
    
    // Parsing
    api(libs.ksoup)
    api(libs.xmlbuilder)
    api(libs.csv)
    
    // Crypto
    api(libs.cryptography.core)
    api(libs.cryptography.provider.jdk)
    api(libs.kotlinx.crypto.crc32)
    
    // Storage
    api(libs.androidx.documentfile)
    api(libs.androidx.preference.ktx)
    api(libs.multiplatformSettings)
    api(libs.multiplatformSettings.noArg)
    api(libs.kmpfile)
    
    // Download
    api(libs.ketch.core)
    api(libs.ketch.ktor)
    api(libs.ketch.sqlite)
    
    // UI
    api(libs.filekit.core)
    api(libs.zwander.composedialog)
    api(libs.zwander.materialyou)
    api(libs.richeditor.compose)
    
    // Utilities
    api(libs.semver)
    api(libs.moko.resources)
    api(libs.androidx.performance.annotation)
    
    // Crash reporting
    api(libs.bugsnag.android)
    
    // Android/JVM specific desugaring
    coreLibraryDesugaring(libs.desugar.jdk.libs)
}

buildkonfig {
    packageName = "com.samsung.firmware.common"
    objectName = "GradleConfig"
    exposeObjectWithName = objectName

    defaultConfigs {
        buildConfigField(STRING, "versionName", "${rootProject.extra["versionName"]}")
        buildConfigField(STRING, "versionCode", "${rootProject.extra["versionCode"]}")
        buildConfigField(STRING, "appName", "${rootProject.extra["appName"]}")
        buildConfigField(STRING, "bugsnagAndroidApiKey", "${rootProject.extra["bugsnagAndroidApiKey"]}")
    }
}

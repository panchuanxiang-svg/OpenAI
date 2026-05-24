# Retrofit
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

# OkHttp
-keep class okhttp3.** { *; }
-keepattributes Signature

# Kotlinx Serialization
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.SerializationKt
-keep class kotlinx.serialization.** { *; }
-keepclassmembers class kotlinx.serialization.** { *; }

# Kotlin
-keep class kotlin.** { *; }
-dontnote kotlin.**

# Coroutines
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}

# Ktor
-keep class io.ktor.** { *; }

# Keep all classes in our package
-keep class com.samsung.firmware.** { *; }

# Debugging
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

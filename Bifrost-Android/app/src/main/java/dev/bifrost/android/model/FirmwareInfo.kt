package dev.bifrost.android.model

data class FirmwareInfo(
    val model: String,
    val region: String,
    val version: String,
    val androidVersion: String,
    val url: String,
    val encrypted: Boolean
)
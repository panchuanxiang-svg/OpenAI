package com.samsung.firmware.common.data.model

import kotlinx.serialization.Serializable

@Serializable
data class FirmwareInfo(
    val model: String,
    val region: String,
    val version: String,
    val releaseDate: String,
    val size: Long,
    val description: String = "",
    val url: String = "",
    val checksum: String = "",
    val isBeta: Boolean = false
)

@Serializable
data class DownloadProgress(
    val bytesDownloaded: Long,
    val totalBytes: Long,
    val percentage: Int
) {
    val isComplete: Boolean
        get() = bytesDownloaded >= totalBytes
}

data class DecryptionResult(
    val success: Boolean,
    val outputPath: String,
    val error: String? = null
)

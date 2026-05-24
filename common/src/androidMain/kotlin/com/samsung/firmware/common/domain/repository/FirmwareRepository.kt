package com.samsung.firmware.common.domain.repository

import com.samsung.firmware.common.data.model.FirmwareInfo
import kotlinx.coroutines.flow.Flow

interface FirmwareRepository {
    /**
     * 搜索固件
     */
    suspend fun searchFirmware(
        model: String,
        region: String,
        includeBeta: Boolean = false
    ): Result<List<FirmwareInfo>>

    /**
     * 下载固件（带进度）
     */
    fun downloadFirmware(
        firmware: FirmwareInfo,
        outputPath: String
    ): Flow<DownloadProgress>

    /**
     * 解密固件
     */
    suspend fun decryptFirmware(
        encryptedPath: String,
        outputPath: String
    ): Result<String>
}

data class DownloadProgress(
    val bytesDownloaded: Long,
    val totalBytes: Long,
    val percentage: Int
)

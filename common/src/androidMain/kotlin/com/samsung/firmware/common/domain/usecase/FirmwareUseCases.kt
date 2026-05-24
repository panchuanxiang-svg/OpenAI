package com.samsung.firmware.common.domain.usecase

import com.samsung.firmware.common.data.model.FirmwareInfo
import com.samsung.firmware.common.domain.repository.FirmwareRepository

class SearchFirmwareUseCase(
    private val repository: FirmwareRepository
) {
    suspend operator fun invoke(
        model: String,
        region: String,
        includeBeta: Boolean = false
    ): Result<List<FirmwareInfo>> {
        // 验证输入
        if (model.isBlank() || region.isBlank()) {
            return Result.failure(IllegalArgumentException("Model and region cannot be empty"))
        }

        return try {
            repository.searchFirmware(
                model = model.uppercase(),
                region = region.uppercase(),
                includeBeta = includeBeta
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

class DownloadFirmwareUseCase(
    private val repository: FirmwareRepository
) {
    operator fun invoke(
        firmware: FirmwareInfo,
        outputPath: String
    ) = repository.downloadFirmware(firmware, outputPath)
}

class DecryptFirmwareUseCase(
    private val repository: FirmwareRepository
) {
    suspend operator fun invoke(
        encryptedPath: String,
        outputPath: String
    ): Result<String> {
        if (encryptedPath.isBlank() || outputPath.isBlank()) {
            return Result.failure(IllegalArgumentException("Paths cannot be empty"))
        }

        return repository.decryptFirmware(encryptedPath, outputPath)
    }
}

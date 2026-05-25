package dev.bifrost.android.provider

import dev.bifrost.android.model.FirmwareInfo

interface FirmwareProvider {

    suspend fun search(
        model: String,
        region: String
    ): List<FirmwareInfo>
}
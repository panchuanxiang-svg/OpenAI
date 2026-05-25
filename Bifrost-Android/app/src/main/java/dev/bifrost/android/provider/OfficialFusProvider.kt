package dev.bifrost.android.provider

import dev.bifrost.android.fus.FusClient
import dev.bifrost.android.model.FirmwareInfo

class OfficialFusProvider : FirmwareProvider {

    override suspend fun search(
        model: String,
        region: String
    ): List<FirmwareInfo> {

        val fileName =
            "${model}_${region}_latest.zip.enc4"

        val url = FusClient.buildFirmwareUrl(
            model,
            region,
            fileName
        )

        return listOf(
            FirmwareInfo(
                model = model,
                region = region,
                version = "LATEST",
                androidVersion = "14",
                url = url,
                encrypted = true
            )
        )
    }
}
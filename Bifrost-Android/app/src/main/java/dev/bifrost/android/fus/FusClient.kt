package dev.bifrost.android.fus

import okhttp3.OkHttpClient

object FusClient {

    private const val BASE_URL =
        "https://fota-cloud-dn.ospserver.net/firmware"

    val client = OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .build()

    fun buildFirmwareUrl(
        model: String,
        region: String,
        file: String
    ): String {

        return "$BASE_URL/$region/$model/$file"
    }
}
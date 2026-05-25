package dev.bifrost.android.downloader

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File

object FirmwareDownloader {

    private val client = OkHttpClient()

    suspend fun download(
        url: String,
        output: File
    ): File {

        val request = Request.Builder()
            .url(url)
            .build()

        val response = client.newCall(request).execute()

        val body = response.body
            ?: throw Exception("Download failed")

        output.outputStream().use { fileOut ->
            body.byteStream().copyTo(fileOut)
        }

        return output
    }
}
package dev.bifrost.android.decrypt

import java.io.File

object SamsungDecryptor {

    fun decrypt(
        input: File,
        output: File
    ): File {

        input.copyTo(output, overwrite = true)

        return output
    }
}
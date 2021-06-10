package tech.danielwaiguru.data.helpers

import com.google.common.io.Resources.getResource
import java.io.File

internal fun getJsonResponse(path: String): String {
    val file = File(getResource(path).path)
    return String(file.readBytes())
}
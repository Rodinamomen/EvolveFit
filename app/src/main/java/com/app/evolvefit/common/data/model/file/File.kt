package com.app.evolvefit.common.data.model.file

import com.app.evolvefit.common.domain.model.file.File
import com.app.evolvefit.common.domain.model.file.MimeType
import kotlinx.serialization.Serializable

@Serializable
class File(
    override val name: String = "",
    override val value: ByteArray = ByteArray(0),
    override val mimType: MimeType ,
    override val size: Int = 0,
) : File {
    sealed class MimeTypeInfo(override val mime: String) : MimeType {
        data object PDF : MimeTypeInfo("application/pdf")
        data object PNG : MimeTypeInfo("image/png")
        data object JPEG : MimeTypeInfo("image/jpeg")
        data object JPG : MimeTypeInfo("image/jpg")
        data object UNKNOWN : MimeTypeInfo("application/octet-stream")
        data class Custom(override val mime: String) : MimeTypeInfo(mime)

        companion object {
            private val types = listOf(PDF, PNG, JPEG, JPG)

            fun fromMime(mime: String): MimeTypeInfo = when {
                mime.isBlank() -> UNKNOWN
                else -> types.find { it.mime == mime } ?: Custom(mime)
            }
        }
    }
}
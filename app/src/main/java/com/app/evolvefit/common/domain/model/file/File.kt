package com.app.evolvefit.common.domain.model.file

interface File {
    val name: String
    val value: ByteArray
    val mimType: MimeType
    val size: Int
}
package com.app.evolvefit.common.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class APIErrorResponse(
    @SerialName("message")
    val message: String,
    @SerialName("errors")
    val errors: Map<ErrorKey, List<String>>?
)
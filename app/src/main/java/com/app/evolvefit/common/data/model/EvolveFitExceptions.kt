package com.app.evolvefit.common.data.model

import com.app.evolvefit.common.domain.model.RequestErrorKey

sealed class EvolveFitException(message: String?) : Exception(message) {
    sealed class Network(override val message: String? = null) : EvolveFitException(message) {
        data class Repeatable(override val message: String? = null) : Network(message)
        data class Unhandled(val errorCode: Int, override val message: String? = null) :
            Network(message = "Network Unhandled error with code:${errorCode}, and the failure reason: $message")
    }

    sealed class Client(override val message: String?) : EvolveFitException(message) {
        data object UnAuthorized : Client(message = "Unauthorized")
        data class ResponseValidation(
            val errors: Map<ErrorKey, String>,
            override val message: String? = null
        ) : Client(message)

        data class Unhandled(val errorCode: Int, override val message: String? = null) :
            Client(message = "Client Unhandled error with code:${errorCode}, and the failure reason: $message")
    }

    sealed class Server(message: String?) : EvolveFitException(message) {
        data class InternalServerError(
            override val message: String? = null,
            val httpErrorCode: Int
        ) : Server(message = "Internal server error with code:${httpErrorCode}, and the failure reason: $message")
    }

    sealed class Local(message: String?) : EvolveFitException(message) {
        data class RequestValidation(
            override val message: String? = null,
            val errors: Map<ErrorKey, RequestErrorKey> = hashMapOf(),
        ) : Local(message)

        data class IOOperation(override val message: String? = null) :
            Local(message)

        data class Unhandled(val errorCode: Int, override val message: String? = null) :
            Local(message = "Local Unhandled error with code:${errorCode}, and the failure reason: $message")
    }

    data class UnKnown(override val message: String? = null) : EvolveFitException(message)
}
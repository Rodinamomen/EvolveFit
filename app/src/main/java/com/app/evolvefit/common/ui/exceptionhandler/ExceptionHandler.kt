package com.app.evolvefit.common.ui.exceptionhandler

import com.app.evolvefit.R
import com.app.evolvefit.common.data.model.EvolveFitException
import com.app.evolvefit.common.domain.model.ErrorKey
import com.app.evolvefit.common.domain.model.RequestErrorKey
import com.app.evolvefit.common.ui.messagecontroller.MessageEvent
import com.app.evolvefit.common.ui.messagecontroller.MessageController
import com.app.evolvefit.common.ui.stringhandler.UIText

class ExceptionHandler(
    private val messageController: MessageController,
) {
    operator fun invoke(
        exception: EvolveFitException,
        onRequestValidation: (Map<ErrorKey, UIText>) -> Unit = {},
    ) {
        when (exception) {
            is EvolveFitException.Client.UnAuthorized -> {
                // TODO HANDLE AUTH EXCEPTION
            }

            is EvolveFitException.Local.RequestValidation -> onRequestValidation(
                exception.errors
                    .mapValues { requestErrorMap[it.value] ?: UIText.StringResource(R.string.unknown) }
            )

            else -> messageController.fireMessage(
                MessageEvent.Toast(exception.message?.let {
                    UIText.DynamicString(it)
                } ?: UIText.StringResource(R.string.unknown))
            )
        }
    }

    // TODO Enhance it to split it out
    // Violate open closed principle
    companion object {
        private val requestErrorMap = mapOf<RequestErrorKey, UIText>(

        )
    }
}
package com.app.evolvefit.common.ui.extensions

import com.app.evolvefit.common.data.model.EvolveFitException
import com.app.evolvefit.common.domain.model.ErrorKey
import com.app.evolvefit.common.domain.model.Resource
import com.app.evolvefit.common.ui.exceptionhandler.ExceptionHandler
import com.app.evolvefit.common.ui.stringhandler.UIText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun <Result> Flow<Resource<Result>>.collectResource(
    scope: CoroutineScope,
    exceptionHandler: ExceptionHandler,
    onRequestValidation: (Map<ErrorKey, UIText>) -> Unit = {},
    onSuccess: suspend (Result) -> Unit = {},
    onFailure: suspend (EvolveFitException) -> Unit = {},
    onLoading: suspend (Boolean) -> Unit = {},
) = scope.launch {
    this@collectResource.collect { resource ->
        when (resource) {
            is Resource.Failure -> {
                exceptionHandler(resource.exception, onRequestValidation)
                onFailure(resource.exception)
            }

            is Resource.Loading -> onLoading(resource.isLoading)
            is Resource.Success -> onSuccess(resource.model)
        }
    }
}
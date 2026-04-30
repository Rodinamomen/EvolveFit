package com.app.evolvefit.common.domain.usecase

import com.app.evolvefit.common.data.model.EvolveFitException
import com.app.evolvefit.common.domain.model.Resource

class HandleFailure {
    operator fun invoke(exception: Throwable): Resource.Failure {
        val failureException = exception as? EvolveFitException
            ?: EvolveFitException.UnKnown(message = "Unknown Error $exception")
        return Resource.Failure(failureException)
    }
}
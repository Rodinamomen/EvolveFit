package com.app.evolvefit.common.domain.usecase

import com.app.evolvefit.common.domain.model.Resource

class NonFlowExecutor(private val handleFailure: HandleFailure) {
    suspend fun <Domain> nonFlowExecute(
        codeBlock: suspend () -> Domain,
    ): Resource<Domain> = runCatching {
        Resource.Success(codeBlock.invoke())
    }.getOrElse { handleFailure(it) }
}
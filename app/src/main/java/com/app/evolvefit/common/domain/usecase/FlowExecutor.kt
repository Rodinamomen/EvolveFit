package com.app.evolvefit.common.domain.usecase

import com.app.evolvefit.common.domain.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.onStart

class FlowExecutor(private val handleFailure: HandleFailure, ) {
    fun <Domain> flowExecute(
        codeBlock: suspend () -> Domain,
    ): Flow<Resource<Domain>> = channelFlow {
        send(Resource.Success(codeBlock.invoke()))
        send(Resource.Loading(isLoading = false))
    }.onStart {
        emit(Resource.Loading(isLoading = true))
    }.catch { exception ->
        emit(handleFailure(exception))
        emit(Resource.Loading(isLoading = false))
    }
}
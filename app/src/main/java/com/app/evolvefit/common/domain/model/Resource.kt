package com.app.evolvefit.common.domain.model

import com.app.evolvefit.common.data.model.EvolveFitException

sealed class Resource<out Model> {
    data class Success<out Model>(val model: Model) : Resource<Model>()
    data class Failure(val exception: EvolveFitException) : Resource<Nothing>()
    data class Loading(val isLoading: Boolean = false) : Resource<Nothing>()
}
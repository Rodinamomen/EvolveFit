package com.app.evolvefit.common.ui.loadingcontroller

sealed interface LoadingEvent {
    val isLoading : Boolean
    data class CircularProgressIndicator(override val isLoading: Boolean) : LoadingEvent
}
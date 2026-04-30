package com.app.evolvefit.common.ui.statecontroller

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class StateController<State>(stateType: State) {
    private val _state = MutableStateFlow(stateType)
    val state = _state.asStateFlow()

    fun updateState(update: State.() -> State) {
        _state.update { it.update() }
    }
}
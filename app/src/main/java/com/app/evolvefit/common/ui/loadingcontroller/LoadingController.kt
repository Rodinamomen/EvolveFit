package com.app.evolvefit.common.ui.loadingcontroller

import com.app.evolvefit.common.ui.eventcontroller.EventController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named

class LoadingController(private val viewModelScope: CoroutineScope) : KoinComponent {
    private val loadingEvent: EventController<LoadingEvent> by inject(named("LoadingEvent"))

    fun fireLoading(loadingEventType: LoadingEvent) = viewModelScope.launch { loadingEvent.emit(loadingEventType) }
}
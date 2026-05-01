package com.app.evolvefit.common.ui.eventcontroller

import kotlinx.coroutines.flow.Flow

interface EventController<Event> {
    val event: Flow<Event>
    suspend fun emit(event: Event)
}
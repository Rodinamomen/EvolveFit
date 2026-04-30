package com.app.evolvefit.common.ui.messagecontroller

import com.app.evolvefit.common.ui.eventcontroller.EventController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named

class MessageController(private val viewModelScope: CoroutineScope) : KoinComponent {
    private val messageEvent: EventController<MessageEvent> by inject(named("MessageEvent"))
    fun fireMessage(messageEventType: MessageEvent) = viewModelScope.launch { messageEvent.emit(messageEventType) }
}
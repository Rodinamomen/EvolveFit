package com.app.evolvefit.common.ui.languagecontroller

import com.app.evolvefit.common.ui.eventcontroller.EventController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named

class LanguageController(private val viewModelScope: CoroutineScope) : KoinComponent {
    private val languageEvent: EventController<LanguageEvent> by inject(named("LanguageEvent"))
    fun fireLanguageEvent(language: String) {
        viewModelScope.launch {
            languageEvent.emit(LanguageEvent.ChangeLanguage(language))
        }
    }
}
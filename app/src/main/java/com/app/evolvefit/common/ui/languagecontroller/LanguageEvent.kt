package com.app.evolvefit.common.ui.languagecontroller

sealed interface LanguageEvent {
    val languageCode : String
    data class ChangeLanguage(override val languageCode: String) : LanguageEvent
}
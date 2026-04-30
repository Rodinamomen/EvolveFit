package com.app.evolvefit.common.ui.navigation.navigationcontroller

import androidx.navigation.NavOptionsBuilder

sealed class NavigationEvent {
    data class Navigate(
        val destination: Destination, val builder: NavOptionsBuilder.() -> Unit = {}
    ) : NavigationEvent()

    data object NavigateUp : NavigationEvent()
}
package com.app.evolvefit.common.ui.navigation.navigationcontroller

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NavigationController(private val viewModelScope: CoroutineScope) : KoinComponent {
    private val navigator: Navigator by inject()

    fun fireNavigate(destination: Destination, builder: NavOptionsBuilder.() -> Unit = {}) =
        viewModelScope.launch { navigator.navigate(destination, builder = builder) }

    suspend fun fireNavigateUp() {
        navigator.navigateUp()
    }
}
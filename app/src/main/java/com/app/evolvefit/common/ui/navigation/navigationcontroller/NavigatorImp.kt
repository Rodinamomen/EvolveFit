package com.app.evolvefit.common.ui.navigation.navigationcontroller

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class NavigatorImp(override val startGraph: Graph) : Navigator {
    private val _navigateEvent = Channel<NavigationEvent>()
    override val navigationEvent = _navigateEvent.receiveAsFlow()

    override suspend fun navigate(destination: Destination, builder: NavOptionsBuilder.() -> Unit) =
        _navigateEvent.send(NavigationEvent.Navigate(destination = destination, builder = builder))

    override suspend fun navigateUp() = _navigateEvent.send(NavigationEvent.NavigateUp)
}
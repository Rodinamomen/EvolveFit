package com.app.evolvefit.common.ui.navigation.navigationcontroller

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.Flow

interface Navigator {
    val startGraph: Graph
    val navigationEvent: Flow<NavigationEvent>
    suspend fun navigate(destination: Destination, builder: NavOptionsBuilder.() -> Unit = {})
    suspend fun navigateUp()
}
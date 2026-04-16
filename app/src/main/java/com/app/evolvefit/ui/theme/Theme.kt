package com.app.evolvefit.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun EvolveFitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if( darkTheme) darkScheme else lightScheme
    CompositionLocalProvider(
        localColors provides colorScheme,
    ) {
        content()
    }
}

object EvolveFitTheme{
    val colors : EvolveFitColors
        @Composable get() = localColors.current
}
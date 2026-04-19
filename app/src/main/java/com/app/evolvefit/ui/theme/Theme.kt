package com.app.evolvefit.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.app.evolvefit.ui.theme.color.EvolveFitColors
import com.app.evolvefit.ui.theme.color.darkScheme
import com.app.evolvefit.ui.theme.color.lightScheme
import com.app.evolvefit.ui.theme.color.localColors
import com.app.evolvefit.ui.theme.textstyles.EvolveFitTextStyle
import com.app.evolvefit.ui.theme.textstyles.TextStyle
import com.app.evolvefit.ui.theme.textstyles.localTextStyle

@Composable
fun EvolveFitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) darkScheme else lightScheme
    CompositionLocalProvider(
        localColors provides colorScheme,
        localTextStyle provides TextStyle(),
    ) {
        content()
    }
}

object EvolveFitTheme {
    val colors: EvolveFitColors
        @Composable get() = localColors.current
    val textStyle: EvolveFitTextStyle
        @Composable get() = localTextStyle.current
}
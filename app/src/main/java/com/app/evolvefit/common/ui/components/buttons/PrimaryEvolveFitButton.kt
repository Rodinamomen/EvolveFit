package com.app.evolvefit.common.ui.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.app.evolvefit.common.ui.components.multipreview.PreviewAllVariants
import com.app.evolvefit.common.ui.theme.EvolveFitTheme

@Composable
fun PrimaryEvolveFitButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = EvolveFitButtonDefaults.shape,
    isEnabled: Boolean = EvolveFitButtonDefaults.isEnabled,
    isLoading: Boolean = EvolveFitButtonDefaults.isLoading,
    horizontalArrangement: Arrangement.Horizontal = EvolveFitButtonDefaults.horizontalArrangement,
    verticalAlignment: Alignment.Vertical = EvolveFitButtonDefaults.verticalAlignment,
    colors:EvolveFitButtonColors = EvolveFitButtonDefaults.PrimaryColors(),
) {
    EvolveFitButton(
        modifier = modifier,
        label = label,
        onClick = onClick,
        shape = shape,
        isEnabled = isEnabled,
        isLoading = isLoading,
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment,
        colors = colors
    )
}

@Composable
@PreviewAllVariants
private fun PrimaryEvolveFitButtonPreview() = EvolveFitTheme {
    PrimaryEvolveFitButton(
        label = "EvolveFit",
        onClick = {}
    )
}
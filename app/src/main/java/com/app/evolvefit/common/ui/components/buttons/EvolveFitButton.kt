package com.app.evolvefit.common.ui.components.buttons

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.app.evolvefit.common.ui.components.buttons.EvolveFitButtonDefaults.RippleColor
import com.app.evolvefit.common.ui.components.loading.LoadingIndicator
import com.app.evolvefit.common.ui.components.multipreview.PreviewAllVariants
import com.app.evolvefit.common.ui.theme.EvolveFitTheme

@Composable
fun EvolveFitButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = EvolveFitButtonDefaults.shape,
    isEnabled: Boolean = EvolveFitButtonDefaults.isEnabled,
    isLoading: Boolean = EvolveFitButtonDefaults.isLoading,
    horizontalArrangement: Arrangement.Horizontal = EvolveFitButtonDefaults.horizontalArrangement,
    verticalAlignment: Alignment.Vertical = EvolveFitButtonDefaults.verticalAlignment,
    colors: EvolveFitButtonColors = EvolveFitButtonDefaults.colors(),
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = EvolveFitButtonDefaults.ContainerColor(
                    isEnabled = isEnabled,
                    containerColor = colors.containerColor,
                    disabledContainerColor = colors.disabledContainerColor
                ),
                shape = shape
            )
            .clip(shape = shape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(
                    color = RippleColor(
                        isEnabled = isEnabled,
                        rippleColor = colors.rippleColor,
                        disabledRipplerColor = colors.disabledRippleColor
                    ),
                )
            ) { onClick() }
            .padding(
                vertical = EvolveFitButtonDefaults.verticalPadding,
                horizontal = EvolveFitButtonDefaults.horizontalPadding
            ),
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement
    ) {
        Text(
            text = label,
            color = EvolveFitButtonDefaults.ContentColor(
                isEnabled = isEnabled,
                contentColor = colors.contentColor,
                disabledContentColor = colors.disabledContentColor
            ),
            style = EvolveFitButtonDefaults.textStyle
        )
        AnimatedVisibility(visible = isLoading) { LoadingIndicator() }
    }
}

data class EvolveFitButtonColors(
    val containerColor: Color = Color.Unspecified,
    val contentColor: Color = Color.Unspecified,
    val disabledContainerColor: Color = Color.Unspecified,
    val disabledContentColor: Color = Color.Unspecified,
    val rippleColor: Color = Color.Unspecified,
    val disabledRippleColor: Color = Color.Unspecified,
)

object EvolveFitButtonDefaults {
    val verticalPadding: Dp = 16.dp
    val horizontalPadding: Dp = 12.dp
    val isLoading: Boolean = false
    val isEnabled: Boolean = true
    val horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
    val verticalAlignment = Alignment.CenterVertically
    val shape: Shape = RoundedCornerShape(24.dp)
    val textStyle: TextStyle
        @Composable
        get() = EvolveFitTheme.textStyle.title.mediumMedium14

    fun colors(
        containerColor: Color = Color.Unspecified,
        contentColor: Color = Color.Unspecified,
        disabledContainerColor: Color = Color.Unspecified,
        disabledContentColor: Color = Color.Unspecified,
        rippleColor: Color = Color.Unspecified,
        disabledRippleColor: Color = Color.Unspecified,
    ): EvolveFitButtonColors =
        EvolveFitButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
            rippleColor = rippleColor,
            disabledRippleColor = disabledRippleColor
        )

    @Composable
    fun ContainerColor(
        isEnabled: Boolean,
        containerColor: Color,
        disabledContainerColor: Color,
    ) = if (isEnabled) containerColor else disabledContainerColor

    @Composable
    fun ContentColor(
        isEnabled: Boolean,
        contentColor: Color,
        disabledContentColor: Color,
    ) =
        if (isEnabled) contentColor else disabledContentColor

    @Composable
    fun RippleColor(
        isEnabled: Boolean,
        rippleColor: Color,
        disabledRipplerColor: Color,
    ) = if (isEnabled) rippleColor else disabledRipplerColor

    @Composable
    fun PrimaryColors(
        containerColor: Color = EvolveFitTheme.colors.brand.primary,
        contentColor: Color = EvolveFitTheme.colors.brand.onPrimary,
        disabledContainerColor: Color = EvolveFitTheme.colors.surface.outlineVariant,
        disabledContentColor: Color = EvolveFitTheme.colors.surface.outline,
        rippleColor: Color = EvolveFitTheme.colors.brand.onPrimary,
        disabledRippleColor: Color = EvolveFitTheme.colors.surface.outline,
    ): EvolveFitButtonColors =
        EvolveFitButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
            rippleColor = rippleColor,
            disabledRippleColor = disabledRippleColor
        )
}

@Composable
@PreviewAllVariants
private fun EvolveFitButtonPreview() = EvolveFitTheme {
    EvolveFitButton(
        modifier = Modifier.fillMaxWidth(),
        colors = EvolveFitButtonDefaults.colors(
            containerColor = EvolveFitTheme.colors.brand.primary,
            contentColor = EvolveFitTheme.colors.brand.onPrimary,
            disabledContainerColor = EvolveFitTheme.colors.surface.outlineVariant,
            disabledContentColor = EvolveFitTheme.colors.surface.outline,
            rippleColor = EvolveFitTheme.colors.brand.onPrimary,
            disabledRippleColor = EvolveFitTheme.colors.surface.outline
        ),
        onClick = {},
        label = "button"
    )
}
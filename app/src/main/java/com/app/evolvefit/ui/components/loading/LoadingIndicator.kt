package com.app.evolvefit.ui.components.loading

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.app.evolvefit.ui.components.multipreview.PreviewAllVariants
import com.app.evolvefit.ui.theme.EvolveFitTheme
import com.app.evolvefit.ui.theme.icon.EvolveFitIcons

@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier,
    size: Dp = LoadingIndicatorDefaults.size,
    icon: ImageVector = LoadingIndicatorDefaults.icon,
    iconTint: Color = LoadingIndicatorDefaults.iconColor,
) {
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = iconTint,
        modifier = modifier
            .size(size)
            .rotate(rotation)
    )
}

object LoadingIndicatorDefaults {
    val size: Dp = 20.dp
    val icon: ImageVector
        @Composable
        get() = ImageVector.vectorResource(EvolveFitIcons.Outline.Loading)
    val iconColor: Color
        @Composable
        get() = EvolveFitTheme.colors.brand.onPrimary
}

@PreviewAllVariants
@Composable
private fun LoadingIndicatorPreview() = EvolveFitTheme {
    LoadingIndicator()
}
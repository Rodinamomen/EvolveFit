package com.app.evolvefit.ui.theme.textstyles

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class DisplayTextStyle(
    val largeBold24: TextStyle,
    val largeBold20: TextStyle,
    val mediumMedium20: TextStyle,
    val largeBold18: TextStyle,
)
data class HeadlineTextStyle(
    val largeBold18: TextStyle,
    val mediumMedium18: TextStyle,
    val largeBold16: TextStyle,
    val mediumMedium16: TextStyle,
)
data class TitleTextStyle(
    val largeBold16: TextStyle,
    val mediumMedium16: TextStyle,
    val largeBold14: TextStyle,
    val mediumMedium14: TextStyle,
)
data class LabelTextStyle(
    val mediumMedium16: TextStyle,
    val mediumMedium14: TextStyle,
    val smallRegular14: TextStyle,
    val mediumMedium12: TextStyle,
    val smallRegular12: TextStyle,
)
data class BodyTextStyle(
    val smallRegular16: TextStyle,
    val mediumMedium14: TextStyle,
    val mediumMedium12: TextStyle,
    val smallRegular10: TextStyle,
)
data class EvolveFitTextStyle(
    val display: DisplayTextStyle,
    val headline: HeadlineTextStyle,
    val title: TitleTextStyle,
    val label: LabelTextStyle,
    val body: BodyTextStyle,
)

@Composable
fun TextStyle(): EvolveFitTextStyle {
    val fontFamily = EvolveFontFamily()
    return EvolveFitTextStyle(
        display = DisplayTextStyle(
            largeBold24 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            ),
            largeBold20 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            ),
            mediumMedium20 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            ),
            largeBold18 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        ),
        headline = HeadlineTextStyle(
            largeBold18 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            mediumMedium18 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            ),
            largeBold16 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ),
            mediumMedium16 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
        ),
        title = TitleTextStyle(
            largeBold16 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ),
            mediumMedium16 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            ),
            largeBold14 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            ),
            mediumMedium14 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        ),
        label = LabelTextStyle(
            mediumMedium16 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            ),
            mediumMedium14 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            ),
            smallRegular14 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            ),
            mediumMedium12 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            ),
            smallRegular12 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
        ),
        body = BodyTextStyle(
            smallRegular16 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            mediumMedium14 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            ),
            mediumMedium12 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            ),
            smallRegular10 = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp
            )
        )
    )
}
val localTextStyle = staticCompositionLocalOf<EvolveFitTextStyle> { error("Cannot provide text style") }
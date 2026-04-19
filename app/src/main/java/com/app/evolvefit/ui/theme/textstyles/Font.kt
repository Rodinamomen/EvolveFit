package com.app.evolvefit.ui.theme.textstyles

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.app.evolvefit.R

@Composable
fun EvolveFontFamily(): FontFamily {
    return FontFamily(
        Font(R.font.lato_bold, FontWeight.Bold),
        Font(R.font.lato_medium, FontWeight.Medium),
        Font(R.font.lato_regular, FontWeight.Normal),
        )
}
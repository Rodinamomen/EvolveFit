package com.app.evolvefit.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class Brand(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
)

data class Surface(
    val surface: Color,
    val onSurface: Color,
    val surfaceContainer: Color,
    val onSurfaceContainer: Color,
    val text: Color,
    val surfaceVariant: Color,
    val onSurfaceVariant: Color,
    val outline: Color,
    val outlineVariant: Color,
    val onSurface100: Color,
    val onSurface200: Color,
    val onSurface300: Color,
    val onSurface400: Color,
)

data class System(
    val warning: Color,
    val success: Color,
    val info: Color,
    val error: Color,
)

data class EvolveFitColors(
    val brand: Brand,
    val surface: Surface,
    val system: System,
)

val lightBrand = Brand(
    primary = Color(0xFF9BE03A),
    onPrimary = Color(0xFF161B07),
    primaryContainer = Color(0xFFF3FAD1),
    onPrimaryContainer = Color(0xFFD0F898)
)
val lightSurface = Surface(
    surface = Color(0xFFFDFDFD),
    onSurface = Color(0xFF2C2C2C),
    surfaceContainer = Color(0xFFF8F8F8),
    onSurfaceContainer = Color(0xFF333333),
    text = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFFFFFFFF),
    onSurfaceVariant = Color(0xFF929292),
    outline = Color(0xFF989898),
    outlineVariant = Color(0xFFE6E9DB),
    onSurface100 = Color(0xAD000000),
    onSurface200 = Color(0x66000000),
    onSurface300 = Color(0x3D000000),
    onSurface400 = Color(0x1F919191)
)
val lightSystem = System(
    warning = Color(0xFFD9CB00),
    success = Color(0xFF8DD876),
    info = Color(0xFF4E95FF),
    error = Color(0xFFE65858)
)
val lightScheme = EvolveFitColors(
    brand = lightBrand,
    surface = lightSurface,
    system = lightSystem
)
val darkBrand = Brand(
    primary = Color(0xFF86D01D),
    onPrimary = Color(0xFF181B14),
    primaryContainer = Color(0xFF151814),
    onPrimaryContainer = Color(0xFFBDDF8C)
)
val darkSurface = Surface(
    surface = Color(0xFF090A09),
    onSurface = Color(0xFFF7F7F7),
    surfaceContainer = Color(0xFF1C1C1C),
    onSurfaceContainer = Color(0xFFFDFDFD),
    text = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFF373737),
    onSurfaceVariant = Color(0xFF828282),
    outline = Color(0xFF9C9C9C),
    outlineVariant = Color(0xFF313131),
    onSurface100 = Color(0xDE000000),
    onSurface200 = Color(0xAD000000),
    onSurface300 = Color(0x61000000),
    onSurface400 = Color(0x1F919191)
)
val darkSystem = System(
    warning = Color(0xFFF5D02D),
    success = Color(0xFF2DAD58),
    info = Color(0xFF2B60D3),
    error = Color(0xFFF65659)
)
val darkScheme = EvolveFitColors(
    brand = darkBrand,
    surface = darkSurface,
    system = darkSystem
)

val localColors = staticCompositionLocalOf<EvolveFitColors> { error("Cannot provide colors") }
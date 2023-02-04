package com.example.diciocodingtest.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val LightGray = Color(0xFFD8D8D8)
val MediumGray = Color(0xFF818589)

val Colors.tabBackgroundColor: Color
    @Composable
    get() = Purple500

val Colors.tabContentColor: Color
    @Composable
    get() = Color.White

val Colors.subtitleTaskItemBackgroundColor: Color
    @Composable
    get() = MediumGray
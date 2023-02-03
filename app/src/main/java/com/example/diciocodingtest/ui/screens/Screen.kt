package com.example.diciocodingtest.ui.screens

sealed class Screen(val route: String) {
    object LandingScreen : Screen("landing_screen")
}
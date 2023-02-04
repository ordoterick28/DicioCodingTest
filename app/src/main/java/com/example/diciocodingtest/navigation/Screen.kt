package com.example.diciocodingtest.navigation

sealed class Screen(val route: String) {
    object LandingScreen : Screen("landing_screen")
}
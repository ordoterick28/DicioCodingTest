package com.example.diciocodingtest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.diciocodingtest.ui.screens.LandingScreen
import com.example.diciocodingtest.ui.screens.Screen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(route = Screen.LandingScreen.route) {
            LandingScreen(navController = navController)
        }
    }
}
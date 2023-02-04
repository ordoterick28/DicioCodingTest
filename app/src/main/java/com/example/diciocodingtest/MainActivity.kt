package com.example.diciocodingtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.diciocodingtest.navigation.SetupNavGraph
import com.example.diciocodingtest.navigation.Screen
import com.example.diciocodingtest.ui.theme.DicioCodingTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DicioCodingTestTheme {
                navController = rememberNavController()
                SetupNavGraph(
                    navController = navController,
                    startDestination = Screen.LandingScreen.route
                )
            }
        }
    }
}


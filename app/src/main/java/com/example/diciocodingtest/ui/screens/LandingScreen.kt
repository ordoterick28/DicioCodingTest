package com.example.diciocodingtest.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.diciocodingtest.ui.screens.registration.RegistrationScreen
import com.example.diciocodingtest.ui.screens.user_list.UsersListScreen

@Composable
fun LandingScreen(
    navController: NavHostController,

    ) {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Usuarios", "Registro")

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state == index,
                    onClick = { state = index }
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            when (state) {
                0 -> {
                    UsersListScreen()

                }
                1 -> {
                    RegistrationScreen()
                }
            }
        }
    }
}
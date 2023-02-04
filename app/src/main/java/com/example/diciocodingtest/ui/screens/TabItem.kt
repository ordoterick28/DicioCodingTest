package com.example.diciocodingtest.ui.screens

import androidx.compose.runtime.Composable
import com.example.diciocodingtest.R
import com.example.diciocodingtest.ui.screens.registration.RegistrationScreen
import com.example.diciocodingtest.ui.screens.user_list.UsersListScreen

sealed class TabItem(var icon: Int, var title: String, var screen: @Composable () -> Unit){

    object Home : TabItem(R.drawable.ic_list, "Usuarios", { UsersListScreen() })
    object Profile : TabItem(R.drawable.ic_register, "Registro", { RegistrationScreen() })

}
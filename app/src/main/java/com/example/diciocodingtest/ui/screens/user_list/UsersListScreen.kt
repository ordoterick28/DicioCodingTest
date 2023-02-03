package com.example.diciocodingtest.ui.screens.user_list

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun UsersListScreen(
    viewModel: UsersListViewModel = hiltViewModel()
) {

    val users = viewModel.userList.collectAsLazyPagingItems()
    val scaffoldState = rememberScaffoldState()

    val TAGS = "UsersListScreen"
    Log.d(TAGS, "eom-> users: $users")

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {

        },
        content = {
            UsersListContent(
                users
            )
        }
    )
}
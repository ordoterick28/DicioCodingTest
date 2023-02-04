package com.example.diciocodingtest.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.diciocodingtest.ui.screens.registration.RegistrationViewModel
import com.example.diciocodingtest.ui.theme.tabBackgroundColor
import com.example.diciocodingtest.ui.theme.tabContentColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun LandingScreen(
    viewModel: RegistrationViewModel = hiltViewModel()
) {

    val tabs = listOf(
        TabItem.Home,
        TabItem.Profile
    )

    val pagerState = rememberPagerState(pageCount = tabs.size)

    Scaffold(
        topBar = {  }
    ) {
        Column() {
            if(pagerState.currentPage == 0){
                viewModel.clearFields()
            }
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }
}



@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun Tabs(
    tabs: List<TabItem>,
    pagerState: PagerState
){

    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colors.tabBackgroundColor,
        contentColor = MaterialTheme.colors.tabContentColor,
        indicator = { tabPositions ->

            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        tabs.forEachIndexed{ index, tab ->
            LeadingIconTab(
                icon = { Icon(
                    painter = painterResource(id = tab.icon),
                    contentDescription = "") },
                text = { Text(text = tab.title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}


@ExperimentalPagerApi
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState){
    HorizontalPager(state = pagerState) { page ->
        tabs[page].screen()
    }
}
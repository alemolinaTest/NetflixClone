package com.amolina.netflix.clone.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amolina.netflix.clone.presentation.ui.HomeScreen


@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
//        composable("news_feed") { NewsFeedScreen() }
//        composable("downloads") { DownloadsScreen() }
    }
}
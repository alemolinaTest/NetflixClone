package com.amolina.netflix.clone.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Main Screen") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Text("Welcome to the Main Screen!", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
package com.amolina.netflix.clone.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun HomeScreen(navHostController: NavController) {
    Column(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        // Hero Section
        HeroSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Movie Carousels
        MovieCarousel("Trending Now", sampleMovies)
        MovieCarousel("Now Playing", sampleMovies)
        MovieCarousel("Upcoming Movies", sampleMovies)
        BottomNavigationBar(navHostController)
    }
}

@Composable
fun HeroSection() {
    Box(modifier = Modifier.fillMaxWidth().height(300.dp)) {
        Image(
            painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/original/sample_banner.jpg"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { /* Play action */ }) {
                Text("Play")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* My List action */ }, colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
                Text("My List")
            }
        }
    }
}

@Composable
fun MovieCarousel(title: String, movies: List<String>) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(title, color = Color.White, style = MaterialTheme.typography.bodyLarge)
        LazyRow(contentPadding = PaddingValues(horizontal = 8.dp)) {
            items(movies) { movie ->
                MoviePoster(movie)
            }
        }
    }
}

@Composable
fun MoviePoster(imageUrl: String) {
    Image(
        painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500/$imageUrl"),
        contentDescription = null,
        modifier = Modifier
            .padding(8.dp)
            .size(150.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

// Sample data for testing
val sampleMovies = List(10) { "sample_poster.jpg" }
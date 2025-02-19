package com.amolina.netflix.clone.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.presentation.viewmodels.MoviesViewModel

@Composable
fun HomeScreen(navHostController: NavController) {
    val viewModel: MoviesViewModel = hiltViewModel()
    val popularMovies = viewModel.popularMovies.collectAsState()
    val nowPlayingMovies = viewModel.nowPlayingMoviesState.collectAsState()
    val upcomingMovies = viewModel.upcomingMoviesState.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HeroSection()
        }

        // Movie Carousels
        item {
            MovieCarousel("Trending Now", popularMovies.value)
        }
        item {
            MovieCarousel("Now Playing", nowPlayingMovies.value)
        }
        item {
            MovieCarousel("Upcoming Movies", upcomingMovies.value)
        }
        item {
            BottomNavigationBar(navHostController)
        }
    }
}

@Composable
fun HeroSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/original/sample_banner.jpg"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { /* Play action */ }) {
                Text("Play")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* My List action */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text("My List")
            }
        }
    }
}

@Composable
fun MovieCarousel(title: String, movies: List<Movie>) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(title, color = Color.White, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(movies) { movie ->
                MoviePoster(movie.posterPath.toString())
            }
        }
    }
}

@Composable
fun MoviePoster(
    imageUrl: String?,
    imageSize: String = "w500",
    modifier: Modifier = Modifier
) {
    val baseUrl = "https://image.tmdb.org/t/p/"
    val fullImageUrl = imageUrl?.let { "$baseUrl$imageSize/$it" } ?: ""

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(Color.White, shape = RoundedCornerShape(8.dp))
    ) {
        SubcomposeAsyncImage(
            model = fullImageUrl,
            contentDescription = "Movie Poster",
            contentScale = ContentScale.Fit, // ✅ Keeps aspect ratio
            loading = {
                CircularProgressIndicator(Modifier.size(32.dp)) // ✅ Show a loading indicator
            },
            error = {
                Box(
                    Modifier
                        .size(120.dp)
                        .background(Color.Red, shape = RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Image Not Found", color = Color.White)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

// Sample data for testing
val sampleMovies = List(10) { "sample_poster.jpg" }
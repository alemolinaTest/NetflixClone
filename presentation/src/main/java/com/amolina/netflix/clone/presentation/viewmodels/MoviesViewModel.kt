package com.amolina.netflix.clone.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amolina.netflix.clone.domain.iteractor.GetMovieRecommendationsUseCase
import com.amolina.netflix.clone.domain.iteractor.GetMovieVideoUseCase
import com.amolina.netflix.clone.domain.iteractor.GetNowPlayingMoviesUseCase
import com.amolina.netflix.clone.domain.iteractor.GetPopularMoviesUseCase
import com.amolina.netflix.clone.domain.iteractor.GetUpcomingMoviesUseCase
import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.presentation.di.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getMovieRecommendationsUseCase: GetMovieRecommendationsUseCase,
    private val getMovieVideoUseCase: GetMovieVideoUseCase,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    private val _popularMoviesState = MutableStateFlow<List<Movie>>(emptyList())
    val popularMovies: StateFlow<List<Movie>> = _popularMoviesState
    private val _nowPlayingMoviesState = MutableStateFlow<List<Movie>>(emptyList())
    val nowPlayingMoviesState: StateFlow<List<Movie>> = _nowPlayingMoviesState
    private val _upcomingMoviesState = MutableStateFlow<List<Movie>>(emptyList())
    val upcomingMoviesState: StateFlow<List<Movie>> = _upcomingMoviesState

    private val _recommendationMoviesState = MutableStateFlow<List<Movie>>(emptyList())
    val recommendationMoviesState: StateFlow<List<Movie>> = _recommendationMoviesState

    init {
        fetchPopularMovies()
        fetchUpcomingMovies()
        fetchNowPlayingMovies()
    }

    private fun fetchPopularMovies() {
        viewModelScope.launch(context = dispatcher) {
             getPopularMoviesUseCase.invoke()
                .collect { movies ->
                    _popularMoviesState.value = movies
                }
        }
    }

    private fun fetchUpcomingMovies() {
        viewModelScope.launch(context = dispatcher) {
            getUpcomingMoviesUseCase.invoke()
                .collect { movies ->
                    _upcomingMoviesState.value = movies

                }
        }
    }

    private fun fetchNowPlayingMovies() {
        viewModelScope.launch(dispatcher) {
            getNowPlayingMoviesUseCase()
                .collect { movies ->
                    _nowPlayingMoviesState.value = movies
                    if (movies.isNotEmpty()) {
                        fetchRecommendationMovies(movies.last().id)
                    }
                }
        }
    }



    private fun fetchRecommendationMovies(movieId: Int) {
        viewModelScope.launch(dispatcher) {
            getMovieRecommendationsUseCase(movieId)
                .collect { movies ->
                    _recommendationMoviesState.value = movies
                }
        }
    }

    private val _movieVideoUrl = MutableStateFlow<String?>(null)
    val movieVideoUrl: StateFlow<String?> = _movieVideoUrl

    fun fetchMovieTrailer(movieId: Int) {
        viewModelScope.launch {
            getMovieVideoUseCase(movieId)
                .collect { result ->

                }
        }
    }

}
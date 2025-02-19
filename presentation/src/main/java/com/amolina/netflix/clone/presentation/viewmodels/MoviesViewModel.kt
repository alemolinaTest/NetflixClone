package com.amolina.netflix.clone.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    init {
        fetchPopularMovies()
        fetchUpcomingMovies()
        fetchNowPLayingMovies()
    }

    private fun fetchPopularMovies() {
        viewModelScope.launch(context = dispatcher) {
            _popularMoviesState.value = getPopularMoviesUseCase.invoke()
        }
    }

    private fun fetchUpcomingMovies() {
        viewModelScope.launch(context = dispatcher) {
            _upcomingMoviesState.value = getUpcomingMoviesUseCase.invoke()
        }
    }

    private fun fetchNowPLayingMovies() {
        viewModelScope.launch(context = dispatcher) {
            _nowPlayingMoviesState.value = getNowPlayingMoviesUseCase.invoke()
        }
    }

}
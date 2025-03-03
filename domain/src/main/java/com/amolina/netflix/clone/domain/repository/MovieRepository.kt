package com.amolina.netflix.clone.domain.repository

import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.domain.model.MovieDetail
import com.amolina.netflix.clone.domain.model.Search
import com.amolina.netflix.clone.domain.model.TvSeries
import com.amolina.netflix.clone.domain.model.Video

interface MovieRepository  {
    suspend fun getUpcomingMovies(): Result<List<Movie>>
    suspend fun getNowPlayingMovies(): Result<List<Movie>>
    suspend fun getTopRatedSeries(): Result<TvSeries>
    suspend fun searchMovies(searchText: String): Result<Search>
    suspend fun getPopularMovies(): Result<List<Movie>>
    suspend fun getMovieDetail(movieId: Int): Result<MovieDetail>
    suspend fun getMovieRecommendations(movieId: Int): Result<List<Movie>>
    suspend fun getMovieVideo(movieId: Int): Result<List<Video>>
}
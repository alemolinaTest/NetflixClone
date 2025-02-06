package com.amolina.netflix.clone.domain.repository

import com.amolina.netflix.clone.domain.model.MovieDetail
import com.amolina.netflix.clone.domain.model.MovieRecommendation
import com.amolina.netflix.clone.domain.model.NowPlaying
import com.amolina.netflix.clone.domain.model.Search
import com.amolina.netflix.clone.domain.model.TvSeries
import com.amolina.netflix.clone.domain.model.UpcomingMovies

interface MovieRepository  {
    suspend fun getUpcomingMovies(): Result<UpcomingMovies>
    suspend fun getNowPlayingMovies(): Result<NowPlaying>
    suspend fun getTopRatedSeries(): Result<TvSeries>
    suspend fun searchMovies(searchText: String): Result<Search>
    suspend fun getPopularMovies(): Result<MovieRecommendation>
    suspend fun getMovieDetail(movieId: Int): Result<MovieDetail>
    suspend fun getMovieRecommendations(movieId: Int): Result<MovieRecommendation>
}
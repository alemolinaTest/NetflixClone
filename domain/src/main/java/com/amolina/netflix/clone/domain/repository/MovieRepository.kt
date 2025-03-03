package com.amolina.netflix.clone.domain.repository

import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.domain.model.MovieDetail
import com.amolina.netflix.clone.domain.model.Search
import com.amolina.netflix.clone.domain.model.TvSeries
import com.amolina.netflix.clone.domain.model.Video
import kotlinx.coroutines.flow.Flow

interface MovieRepository  {
     fun getUpcomingMovies(): Flow<Result<List<Movie>>>
     fun getNowPlayingMovies(): Flow<Result<List<Movie>>>
     fun getTopRatedSeries(): Flow<Result<TvSeries>>
     fun searchMovies(searchText: String): Flow<Result<Search>>
     fun getPopularMovies(): Flow<Result<List<Movie>>>
     fun getMovieDetail(movieId: Int): Flow<Result<MovieDetail>>
     fun getMovieRecommendations(movieId: Int): Flow<Result<List<Movie>>>
     fun getMovieVideo(movieId: Int): Flow<Result<List<Video>>>
}
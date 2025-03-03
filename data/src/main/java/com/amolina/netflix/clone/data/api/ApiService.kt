package com.amolina.netflix.clone.data.api

import com.amolina.netflix.clone.data.api.Constants.API_KEY
import com.amolina.netflix.clone.data.model.MovieDetailModel
import com.amolina.netflix.clone.data.model.MovieRecommendationModel
import com.amolina.netflix.clone.data.model.NowPlayingModel
import com.amolina.netflix.clone.data.model.SearchModel
import com.amolina.netflix.clone.data.model.TvSeriesModel
import com.amolina.netflix.clone.data.model.UpcomingMovieModel
import com.amolina.netflix.clone.data.model.VideoResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/{movie_id}/recommendations")
    suspend fun getMovieRecommendations(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieRecommendationModel

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1
    ): MovieRecommendationModel

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): UpcomingMovieModel

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): NowPlayingModel

    @GET("tv/top_rated")
    suspend fun getTopRatedSeries(
        @Query("api_key") apiKey: String = API_KEY
    ): TvSeriesModel

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") searchText: String,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("Authorization") authorization: String = "Bearer YOUR_AUTH_TOKEN"
    ): SearchModel

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): MovieRecommendationModel

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieDetailModel

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideos(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = "YOUR_API_KEY"
    ): VideoResponseModel
}
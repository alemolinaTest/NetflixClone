package com.amolina.netflix.clone.data.repository

import com.amolina.netflix.clone.data.api.ApiService
import com.amolina.netflix.clone.data.model.toDomain
import com.amolina.netflix.clone.data.model.toVideoDomainList
import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.domain.model.Video
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepositoryImplementation @Inject constructor(private val api: ApiService) :
    MovieRepository {
    override fun getUpcomingMovies(): Flow<Result<List<Movie>>> =
        safeApiCallFlow { api.getUpcomingMovies().toDomain().results }

    override fun getNowPlayingMovies(): Flow<Result<List<Movie>>> =
        safeApiCallFlow { api.getNowPlayingMovies().toDomain().results }

    override fun getTopRatedSeries() = safeApiCallFlow { api.getTopRatedSeries().toDomain() }

    override fun searchMovies(searchText: String) =
        safeApiCallFlow { api.searchMovies(searchText).toDomain() }

    override fun getPopularMovies(): Flow<Result<List<Movie>>> =
        safeApiCallFlow { api.getPopularMovies().toDomain().results }

    override fun getMovieDetail(movieId: Int) =
        safeApiCallFlow { api.getMovieDetail(movieId).toDomain() }

    override fun getMovieRecommendations(movieId: Int): Flow<Result<List<Movie>>> =
        safeApiCallFlow { api.getMovieRecommendations(movieId).toDomain().results }

    override fun getMovieVideo(movieId: Int): Flow<Result<List<Video>>> =
        safeApiCallFlow { api.getMovieVideos(movieId).toVideoDomainList() }

   

    private fun <T> safeApiCallFlow(apiCall: suspend () -> T): Flow<Result<T>> = flow {
        emit(Result.success(apiCall()))
    }.catch { e ->
        emit(Result.failure(Exception("Network error: ${e.message}")))
    }.flowOn(Dispatchers.IO)

}
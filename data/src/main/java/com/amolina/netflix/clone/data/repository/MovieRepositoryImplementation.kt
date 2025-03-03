package com.amolina.netflix.clone.data.repository

import com.amolina.netflix.clone.data.api.ApiService
import com.amolina.netflix.clone.data.model.toDomain
import com.amolina.netflix.clone.data.model.toVideoDomainList
import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.domain.model.Video
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class MovieRepositoryImplementation @Inject constructor(private val api: ApiService) :
    MovieRepository {
    override suspend fun getUpcomingMovies(): Result<List<Movie>> =
        safeApiCall { api.getUpcomingMovies().toDomain().results }

    override suspend fun getNowPlayingMovies(): Result<List<Movie>> =
        safeApiCall { api.getNowPlayingMovies().toDomain().results }

    override suspend fun getTopRatedSeries() = safeApiCall { api.getTopRatedSeries().toDomain() }
    override suspend fun searchMovies(searchText: String) =
        safeApiCall { api.searchMovies(searchText).toDomain() }

    override suspend fun getPopularMovies(): Result<List<Movie>> =
        safeApiCall { api.getPopularMovies().toDomain().results }

    override suspend fun getMovieDetail(movieId: Int) =
        safeApiCall { api.getMovieDetail(movieId).toDomain() }

    override suspend fun getMovieRecommendations(movieId: Int): Result<List<Movie>> =
        safeApiCall { api.getMovieRecommendations(movieId).toDomain().results }

    override suspend fun getMovieVideo(movieId: Int): Result<List<Video>> =
        safeApiCall { api.getMovieVideos(movieId).toVideoDomainList() }

    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
        return withContext(Dispatchers.IO) {
            try {
               val result = Result.success(apiCall())
                result
            } catch (e: HttpException) {
                Result.failure(Exception("Network error: ${e.message()}"))
            } catch (e: Exception) {
                Result.failure(Exception("Unknown error: ${e.message}"))
            }
        }
    }
}
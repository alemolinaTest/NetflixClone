package com.amolina.netflix.clone.data.repository

import com.amolina.netflix.clone.data.api.ApiService
import com.amolina.netflix.clone.data.model.toDomain
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

@Singleton
class MovieRepositoryImplementation @Inject constructor(private val api: ApiService) : MovieRepository {
    override suspend fun getUpcomingMovies() = safeApiCall { api.getUpcomingMovies().toDomain() }
    override suspend fun getNowPlayingMovies() = safeApiCall { api.getNowPlayingMovies().toDomain() }
    override suspend fun getTopRatedSeries() = safeApiCall { api.getTopRatedSeries().toDomain() }
    override suspend fun searchMovies(searchText: String) = safeApiCall { api.searchMovies(searchText).toDomain() }
    override suspend fun getPopularMovies() = safeApiCall { api.getPopularMovies().toDomain() }
    override suspend fun getMovieDetail(movieId: Int) = safeApiCall { api.getMovieDetail(movieId).toDomain() }
    override suspend fun getMovieRecommendations(movieId: Int) = safeApiCall { api.getMovieRecommendations(movieId).toDomain() }

    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
        return withContext(Dispatchers.IO) {
            try {
                Result.success(apiCall())
            } catch (e: HttpException) {
                Result.failure(Exception("Network error: ${e.message()}"))
            } catch (e: Exception) {
                Result.failure(Exception("Unknown error: ${e.message}"))
            }
        }
    }
}
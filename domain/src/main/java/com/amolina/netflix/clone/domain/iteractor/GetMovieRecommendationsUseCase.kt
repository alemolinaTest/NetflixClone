package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetMovieRecommendationsUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(movieId: Int): Flow<List<Movie>> =
        repository.getMovieRecommendations(movieId)
            .map { result -> result.getOrElse { emptyList() } }
}
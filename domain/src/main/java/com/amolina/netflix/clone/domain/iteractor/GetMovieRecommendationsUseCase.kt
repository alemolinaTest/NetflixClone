package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.MovieRecommendation
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieRecommendationsUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(movieId: Int): Result<MovieRecommendation> = repository.getMovieRecommendations(movieId)
}
package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.MovieRecommendation
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(): Result<MovieRecommendation> = repository.getPopularMovies()
}
package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.UpcomingMovies
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(): Result<UpcomingMovies> = repository.getUpcomingMovies()
}

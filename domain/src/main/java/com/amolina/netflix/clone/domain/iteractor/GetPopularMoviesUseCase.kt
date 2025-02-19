package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.Movie
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(): List<Movie> = repository.getPopularMovies().getOrElse { emptyList() }
}
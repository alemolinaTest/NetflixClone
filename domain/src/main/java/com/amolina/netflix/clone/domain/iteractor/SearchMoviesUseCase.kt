package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.Search
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(searchText: String): Result<Search> = repository.searchMovies(searchText)
}
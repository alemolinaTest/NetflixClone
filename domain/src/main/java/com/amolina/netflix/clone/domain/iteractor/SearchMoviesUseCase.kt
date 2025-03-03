package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.Search
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class SearchMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(searchText: String): Flow<Result<Search>> = repository.searchMovies(searchText)
}
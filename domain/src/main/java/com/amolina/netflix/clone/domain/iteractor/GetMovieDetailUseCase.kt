package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.MovieDetail
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(movieId: Int): Flow<Result<MovieDetail>> =
        repository.getMovieDetail(movieId)
}
package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.MovieDetail
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(movieId: Int): Result<MovieDetail> = repository.getMovieDetail(movieId)
}
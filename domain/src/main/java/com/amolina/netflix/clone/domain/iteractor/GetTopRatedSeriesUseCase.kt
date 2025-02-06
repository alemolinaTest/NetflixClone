package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.TvSeries
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject

class GetTopRatedSeriesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(): Result<TvSeries> = repository.getTopRatedSeries()
}
package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.TvSeries
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetTopRatedSeriesUseCase @Inject constructor(private val repository: MovieRepository) {
     operator fun invoke(): Flow<Result<TvSeries>> = repository.getTopRatedSeries()
}
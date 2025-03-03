package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.Video
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetMovieVideoUseCase @Inject constructor(private val repository: MovieRepository) {
     operator fun invoke(movieId: Int): Flow<List<Video>> =
        repository.getMovieVideo(movieId)
            .map { result -> result.getOrElse { emptyList() } }
}
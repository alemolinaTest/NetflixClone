package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.Video
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieVideoUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(movieId: Int): List<Video> =
        repository.getMovieVideo(movieId).getOrElse { emptyList() }
}
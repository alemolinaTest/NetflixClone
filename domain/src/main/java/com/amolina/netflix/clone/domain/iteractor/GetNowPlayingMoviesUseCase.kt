package com.amolina.netflix.clone.domain.iteractor

import com.amolina.netflix.clone.domain.model.NowPlaying
import com.amolina.netflix.clone.domain.repository.MovieRepository
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(): Result<NowPlaying> = repository.getNowPlayingMovies()
}
package com.amolina.netflix.clone.di

import com.amolina.netflix.clone.data.api.ApiService
import com.amolina.netflix.clone.data.repository.MovieRepositoryImplementation
import com.amolina.netflix.clone.domain.iteractor.GetPopularMoviesUseCase
import com.amolina.netflix.clone.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryImplModule {

    @Provides
    @Singleton
    fun providesMovieRepository(apiService: ApiService): MovieRepository =
        MovieRepositoryImplementation(apiService)

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(repository: MovieRepository): GetPopularMoviesUseCase =
        GetPopularMoviesUseCase(repository)
}
package com.amolina.netflix.clone.presentation.di

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME) annotation class IODispatcher
@Qualifier
@Retention(AnnotationRetention.RUNTIME) annotation class DefaultDispatcher
@Qualifier
@Retention(AnnotationRetention.RUNTIME) annotation class MainDispatcher
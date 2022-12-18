package com.bahadori.filimosearch.di

import com.bahadori.filimosearch.features.core.data.remote.FilimoApi
import com.bahadori.filimosearch.features.search.data.repository.SearchRepositoryImpl
import com.bahadori.filimosearch.features.search.domain.repository.SearchRepository
import com.bahadori.filimosearch.features.search.domain.usecase.Search
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchModule {

    @Provides
    @Singleton
    fun provideSearchRepository(api: FilimoApi): SearchRepository {
        return SearchRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSearchUseCase(repository: SearchRepository): Search {
        return Search(repository)
    }
}
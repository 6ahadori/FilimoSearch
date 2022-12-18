package com.bahadori.filimosearch.features.search.data.repository

import com.bahadori.filimosearch.features.core.data.remote.FilimoApi
import com.bahadori.filimosearch.features.search.data.remote.dto.response.SearchResponse
import com.bahadori.filimosearch.features.search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val api: FilimoApi
) : SearchRepository {

    override suspend fun search(query: String): Result<SearchResponse> {
        return try {
            Result.success(api.search(query))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}
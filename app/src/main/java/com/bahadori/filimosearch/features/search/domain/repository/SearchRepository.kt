package com.bahadori.filimosearch.features.search.domain.repository

import com.bahadori.filimosearch.features.search.data.remote.dto.response.SearchResponse

interface SearchRepository {

    suspend fun search(query: String): Result<SearchResponse>
}
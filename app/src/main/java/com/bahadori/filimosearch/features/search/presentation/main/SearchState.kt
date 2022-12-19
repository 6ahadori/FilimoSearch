package com.bahadori.filimosearch.features.search.presentation.main

import com.bahadori.filimosearch.features.core.util.common.Resource
import com.bahadori.filimosearch.features.search.domain.model.Data

data class SearchState(
    val movies: Resource<List<Data>>? = null,
    val query: String? = null
)

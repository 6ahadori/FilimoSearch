package com.bahadori.filimosearch.features.core.data.remote

import com.bahadori.filimosearch.features.core.data.remote.Endpoints.SEARCH_MOVIES
import retrofit2.http.GET

interface FilimoApi {

    @GET(SEARCH_MOVIES)
    suspend fun search()
}
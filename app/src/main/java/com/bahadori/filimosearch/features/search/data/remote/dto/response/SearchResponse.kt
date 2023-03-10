package com.bahadori.filimosearch.features.search.data.remote.dto.response


import androidx.annotation.Keep
import com.bahadori.filimosearch.features.search.domain.model.Data
import com.bahadori.filimosearch.features.search.domain.model.Meta
import com.google.gson.annotations.SerializedName

@Keep
data class SearchResponse(
    @SerializedName("data")
    val `data`: List<Data?>?,
    @SerializedName("meta")
    val meta: Meta?
)
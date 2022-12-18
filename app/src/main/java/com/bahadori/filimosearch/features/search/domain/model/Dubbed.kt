package com.bahadori.filimosearch.features.search.domain.model


import com.google.gson.annotations.SerializedName

data class Dubbed(
    @SerializedName("enable")
    val enable: Boolean?,
    @SerializedName("text")
    val text: String?
)
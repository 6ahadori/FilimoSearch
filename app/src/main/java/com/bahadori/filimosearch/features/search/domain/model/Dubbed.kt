package com.bahadori.filimosearch.features.search.domain.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Dubbed(
    @SerializedName("enable")
    val enable: Boolean?,
    @SerializedName("text")
    val text: String?
)
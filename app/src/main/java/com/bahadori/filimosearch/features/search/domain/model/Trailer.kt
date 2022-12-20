package com.bahadori.filimosearch.features.search.domain.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Trailer(
    @SerializedName("enable")
    val enable: Boolean?,
    @SerializedName("host")
    val host: Any?,
    @SerializedName("url")
    val url: Any?
)
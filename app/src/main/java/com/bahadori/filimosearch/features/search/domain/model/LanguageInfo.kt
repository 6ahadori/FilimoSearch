package com.bahadori.filimosearch.features.search.domain.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class LanguageInfo(
    @SerializedName("flag")
    val flag: String?,
    @SerializedName("text")
    val text: String?
)
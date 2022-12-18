package com.bahadori.filimosearch.features.search.domain.model


import com.google.gson.annotations.SerializedName

data class LanguageInfo(
    @SerializedName("flag")
    val flag: String?,
    @SerializedName("text")
    val text: String?
)
package com.bahadori.filimosearch.features.search.domain.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Audio(
    @SerializedName("isMultiLanguage")
    val isMultiLanguage: Boolean?,
    @SerializedName("languages")
    val languages: List<String?>?
)
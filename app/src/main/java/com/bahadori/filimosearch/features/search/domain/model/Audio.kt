package com.bahadori.filimosearch.features.search.domain.model


import com.google.gson.annotations.SerializedName

data class Audio(
    @SerializedName("isMultiLanguage")
    val isMultiLanguage: Boolean?,
    @SerializedName("languages")
    val languages: List<String?>?
)
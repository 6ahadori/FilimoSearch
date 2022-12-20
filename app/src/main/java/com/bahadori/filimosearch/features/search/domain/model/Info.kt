package com.bahadori.filimosearch.features.search.domain.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Info(
    @SerializedName("background_color")
    val backgroundColor: String?,
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("text_color")
    val textColor: String?,
    @SerializedName("type")
    val type: String?
)
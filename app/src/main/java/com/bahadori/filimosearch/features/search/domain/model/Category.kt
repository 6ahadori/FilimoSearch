package com.bahadori.filimosearch.features.search.domain.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Category(
    @SerializedName("link_key")
    val linkKey: String?,
    @SerializedName("link_type")
    val linkType: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("title_en")
    val titleEn: String?
)
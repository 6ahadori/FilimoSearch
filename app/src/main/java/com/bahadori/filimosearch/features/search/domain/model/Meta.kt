package com.bahadori.filimosearch.features.search.domain.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Meta(
    @SerializedName("filter")
    val filter: Boolean?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("per_page")
    val perPage: Int?,
    @SerializedName("row_count")
    val rowCount: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("title_en")
    val titleEn: String?,
    @SerializedName("tracker")
    val tracker: Any?,
    @SerializedName("trailer")
    val trailer: Trailer?,
    @SerializedName("web_url")
    val webUrl: Any?
)
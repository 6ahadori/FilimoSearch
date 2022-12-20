package com.bahadori.filimosearch.features.search.domain.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Serial(
    @SerializedName("enable")
    val enable: Boolean?,
    @SerializedName("last_part")
    val lastPart: Boolean?,
    @SerializedName("parent_title")
    val parentTitle: String?,
    @SerializedName("part_text")
    val partText: String?,
    @SerializedName("season_id")
    val seasonId: Int?,
    @SerializedName("season_text")
    val seasonText: String?,
    @SerializedName("serial_part")
    val serialPart: String?
)
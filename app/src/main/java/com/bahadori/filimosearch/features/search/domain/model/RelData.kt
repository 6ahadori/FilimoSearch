package com.bahadori.filimosearch.features.search.domain.model


import com.google.gson.annotations.SerializedName

data class RelData(
    @SerializedName("rel_id")
    val relId: Any?,
    @SerializedName("rel_title")
    val relTitle: Any?,
    @SerializedName("rel_type")
    val relType: Any?,
    @SerializedName("rel_type_txt")
    val relTypeTxt: String?,
    @SerializedName("rel_uid")
    val relUid: Any?
)
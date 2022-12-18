package com.bahadori.filimosearch.features.search.domain.model


import com.google.gson.annotations.SerializedName

data class Badge(
    @SerializedName("backstage")
    val backstage: Boolean?,
    @SerializedName("commingsoon")
    val comingSoon: Boolean?,
    @SerializedName("exclusive")
    val exclusive: Boolean?,
    @SerializedName("free")
    val free: Boolean?,
    @SerializedName("hear")
    val hear: Boolean?,
    @SerializedName("info")
    val info: List<Info?>?,
    @SerializedName("online_release")
    val onlineRelease: Boolean?,
    @SerializedName("vision")
    val vision: Boolean?
)
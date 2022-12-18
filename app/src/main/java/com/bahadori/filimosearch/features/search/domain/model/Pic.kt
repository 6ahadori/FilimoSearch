package com.bahadori.filimosearch.features.search.domain.model


import com.google.gson.annotations.SerializedName

data class Pic(
    @SerializedName("movie_img_b")
    val movieImgB: String?,
    @SerializedName("movie_img_m")
    val movieImgM: String?,
    @SerializedName("movie_img_s")
    val movieImgS: String?
)
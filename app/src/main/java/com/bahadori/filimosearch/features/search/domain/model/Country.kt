package com.bahadori.filimosearch.features.search.domain.model


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("country")
    val country: String?,
    @SerializedName("country_en")
    val countryEn: String?
)
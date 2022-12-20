package com.bahadori.filimosearch.features.search.domain.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Data(
    @SerializedName("age_range")
    val ageRange: String?,
    @SerializedName("audio")
    val audio: Audio?,
    @SerializedName("avg_rate_label")
    val avgRateLabel: String?,
    @SerializedName("badge")
    val badge: Badge?,
    @SerializedName("categories")
    val categories: List<Category?>?,
    @SerializedName("commingsoon_txt")
    val comingSoonTxt: String?,
    @SerializedName("countries")
    val countries: List<Country?>?,
    @SerializedName("cover")
    val cover: String?,
    @SerializedName("descr")
    val description: String?,
    @SerializedName("director")
    val director: Any?,
    @SerializedName("dubbed")
    val dubbed: Dubbed?,
    @SerializedName("duration")
    val duration: Any?,
    @SerializedName("freemium")
    val freemium: Boolean?,
    @SerializedName("HD")
    val hD: Boolean?,
    @SerializedName("imdb_rate")
    val imdbRate: String?,
    @SerializedName("language_info")
    val languageInfo: LanguageInfo?,
    @SerializedName("last_watch")
    val lastWatch: List<Any?>?,
    @SerializedName("link_key")
    val linkKey: String?,
    @SerializedName("link_type")
    val linkType: String?,
    @SerializedName("movie_id")
    val movieId: String?,
    @SerializedName("movie_title")
    val movieTitle: String?,
    @SerializedName("movie_title_en")
    val movieTitleEn: String?,
    @SerializedName("output_type")
    val outputType: String?,
    @SerializedName("pic")
    val pic: Pic?,
    @SerializedName("position")
    val position: Int?,
    @SerializedName("pro_year")
    val proYear: String?,
    @SerializedName("publish_date")
    val publishDate: String?,
    @SerializedName("rate_avrage")
    val rateAverage: String?,
    @SerializedName("rate_enable")
    val rateEnable: Boolean?,
    @SerializedName("rate_enable_by_cnt")
    val rateEnableByCnt: Boolean?,
    @SerializedName("rel_data")
    val relData: RelData?,
    @SerializedName("serial")
    val serial: Serial?,
    @SerializedName("sid")
    val sid: Int?,
    @SerializedName("subtitle")
    val subtitle: Subtitle?,
    @SerializedName("tag_id")
    val tagId: Any?,
    @SerializedName("theme")
    val theme: String?,
    @SerializedName("uid")
    val uid: String?,
    @SerializedName("uuid")
    val uuid: String?,
    @SerializedName("watch_list_action")
    val watchListAction: String?,
    @SerializedName("watermark")
    val watermark: Boolean?
)
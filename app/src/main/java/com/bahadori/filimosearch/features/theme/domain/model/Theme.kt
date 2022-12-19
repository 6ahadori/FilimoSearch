package com.bahadori.filimosearch.features.theme.domain.model

sealed class Theme(val key: String) {
    object Day : Theme(KEY_DAY)
    object Night : Theme(KEY_NIGHT)

    companion object {
        private const val KEY_DAY = "day"
        private const val KEY_NIGHT = "night"
        fun fromValue(key: String?): Theme {
            return when (key) {
                KEY_DAY -> Day
                KEY_NIGHT -> Night
                else -> Night
            }
        }
    }
}
package com.bahadori.filimosearch.features.theme.data.pref

import android.content.SharedPreferences
import com.bahadori.filimosearch.features.theme.domain.model.Theme
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThemePreferences @Inject constructor(
    private val preferences: SharedPreferences
) {

    companion object {
        private const val KEY_THEME = "PREF_KEY_THEME"
    }

    fun setTheme(value: Theme) = preferences.edit().putString(KEY_THEME, value.key).apply()
    fun getTheme() = preferences.getString(KEY_THEME, Theme.Night.key)
}
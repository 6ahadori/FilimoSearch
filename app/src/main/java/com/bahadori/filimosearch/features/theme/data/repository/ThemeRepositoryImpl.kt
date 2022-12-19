package com.bahadori.filimosearch.features.theme.data.repository

import com.bahadori.filimosearch.features.theme.data.pref.ThemePreferences
import com.bahadori.filimosearch.features.theme.domain.model.Theme
import com.bahadori.filimosearch.features.theme.domain.repository.ThemeRepository

class ThemeRepositoryImpl(
    private val preferences: ThemePreferences
) : ThemeRepository {
    override fun getTheme(): Theme {
        return Theme.fromValue(preferences.getTheme())
    }

    override fun setTheme(theme: Theme) {
        preferences.setTheme(theme)
    }
}
package com.bahadori.filimosearch.features.theme.domain.repository

import com.bahadori.filimosearch.features.theme.domain.model.Theme

interface ThemeRepository {

    fun getTheme(): Theme

    fun setTheme(theme: Theme)
}
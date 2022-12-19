package com.bahadori.filimosearch.features.search.presentation.main

import com.bahadori.filimosearch.features.theme.domain.model.Theme

sealed class SearchEvent {
    data class OnQueryChanged(val value: String?) : SearchEvent()
    data class SetTheme(val theme: Theme) : SearchEvent()
}

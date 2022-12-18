package com.bahadori.filimosearch.features.search.presentation.main

sealed class SearchEvent {
    data class OnQueryChanged(val value: String?) : SearchEvent()
}

package com.bahadori.filimosearch.features.search.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bahadori.filimosearch.features.search.domain.usecase.Search
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val search: Search
) : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state.asStateFlow()

    init {

    }

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.OnQueryChanged -> {
                doSearch(event.value)
            }
        }
    }

    private fun doSearch(query: String?) {
        search(query).onEach { resource ->
            _state.value = state.value.copy(movies = resource)
        }.launchIn(viewModelScope)
    }
}
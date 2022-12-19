package com.bahadori.filimosearch.features.search.domain.model

sealed class Size {
    object S : Size()
    object M : Size()
    object L : Size()
}
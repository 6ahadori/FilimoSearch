package com.bahadori.filimosearch.features.search.domain.model

import androidx.annotation.Keep

@Keep
sealed class Size {
    object S : Size()
    object M : Size()
    object L : Size()
}
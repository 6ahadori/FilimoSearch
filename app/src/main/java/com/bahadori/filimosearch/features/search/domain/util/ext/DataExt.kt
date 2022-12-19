package com.bahadori.filimosearch.features.search.domain.util.ext

import com.bahadori.filimosearch.features.search.domain.model.Data
import com.bahadori.filimosearch.features.search.domain.model.Size

fun Data.getPoster(size: Size = Size.M): String? {
    return when (size) {
        Size.L -> pic?.movieImgB
        Size.M -> pic?.movieImgM
        Size.S -> pic?.movieImgS
    }
}
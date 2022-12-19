package com.bahadori.filimosearch.features.core.util.ext

import android.view.View
import android.view.View.*

inline var View.isVisible: Boolean
    get() = visibility == VISIBLE
    set(value) {
        visibility = if (value) VISIBLE else GONE
    }

inline var View.isHidden: Boolean
    get() = visibility == GONE
    set(value) {
        visibility = if (value) GONE else VISIBLE
    }

inline var View.isInvisible: Boolean
    get() = visibility == INVISIBLE
    set(value) {
        visibility = if (value) INVISIBLE else VISIBLE
    }

fun View.show() {
    visibility = VISIBLE
}

fun View.hide() {
    visibility = GONE
}

fun View.invisible() {
    visibility = INVISIBLE
}

fun View.enable() {
    isEnabled = true
    alpha = 1f
}

fun View.disable(alphaValue: Float = 0.6f) {
    isEnabled = false
    alpha = alphaValue
}
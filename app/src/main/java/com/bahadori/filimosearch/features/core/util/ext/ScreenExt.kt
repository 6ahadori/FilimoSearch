package com.bahadori.filimosearch.features.core.util.ext

import android.content.res.Resources

inline val Float.px: Int
    get() {
        val scale: Float = Resources.getSystem().displayMetrics.density
        return (this * scale + 0.5f).toInt()
    }

inline val Float.dp: Int
    get() {
        val scale: Float = Resources.getSystem().displayMetrics.density
        return (this / scale + 0.5f).toInt()
    }
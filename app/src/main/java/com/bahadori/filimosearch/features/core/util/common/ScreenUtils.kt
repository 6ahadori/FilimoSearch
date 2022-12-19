package com.bahadori.filimosearch.features.core.util.common

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

object ScreenUtils {

    fun getScreenWidth() = Resources.getSystem().displayMetrics.widthPixels

    fun getScreenHeight() = Resources.getSystem().displayMetrics.heightPixels

    fun getDisplayMetrics(context: Context): DisplayMetrics {
        return context.resources.displayMetrics
    }
}
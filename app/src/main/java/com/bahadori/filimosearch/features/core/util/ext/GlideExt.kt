package com.bahadori.filimosearch.features.core.util.ext

import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun RequestBuilder<Drawable>.fade(duration: Int = 200): RequestBuilder<Drawable> {
    return transition(DrawableTransitionOptions.withCrossFade(duration))
}

fun RequestBuilder<Drawable>.rounded(radius: Int = 4): RequestBuilder<Drawable> {
    return transform(CenterCrop(), RoundedCorners(radius.toFloat().px))
}
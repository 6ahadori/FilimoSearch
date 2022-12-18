package com.bahadori.filimosearch.features.core.util.common

import android.os.Looper
import com.bahadori.filimosearch.R
import java.util.*

object Utils {


    fun checkMainThread() {
        check(Looper.myLooper() == Looper.getMainLooper()) {
            "Expected to be called on the main thread but was " + Thread.currentThread().name
        }
    }

    fun getGreetingMessage(): Int {
        return when (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> R.string.good_morning
            in 12..15 -> R.string.good_afternoon
            in 16..20 -> R.string.good_evening
            in 21..23 -> R.string.good_night
            else -> R.string.hello
        }
    }
}
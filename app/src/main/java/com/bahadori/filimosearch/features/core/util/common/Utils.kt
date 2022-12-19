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
}
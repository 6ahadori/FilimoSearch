package com.bahadori.filimosearch.features.core.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * An Interceptor to attach network headers to api calls
 * according to assignment we must set "jsonType" : "simple" to the request
 */
class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
            .addHeader("Accept", "application/json, text/plain, */*")
            .addHeader("jsonType", "simple")

        return chain.proceed(builder.build())
    }
}
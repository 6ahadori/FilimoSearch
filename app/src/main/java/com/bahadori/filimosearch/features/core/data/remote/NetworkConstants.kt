package com.bahadori.filimosearch.features.core.data.remote

object NetworkConstants {
    /**
     * separating version is useful for different versions of api
     */
    private const val V1 = "/v1"
    private const val EN = "/en"
    const val BASE_URL = "https://www.filimo.com/api$EN$V1/"

    /**
     * Number of retries if network call failed
     */
    const val RETRY = 3

    /**
     * Network timeout in seconds
     */
    const val TIMEOUT: Long = 30

    const val UNKNOWN_ERROR = "An unexpected error occurred"
}
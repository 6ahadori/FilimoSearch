package com.bahadori.filimosearch.di

import com.bahadori.filimosearch.BuildConfig
import com.bahadori.filimosearch.features.core.data.remote.FilimoApi
import com.bahadori.filimosearch.features.core.data.remote.NetworkConstants
import com.bahadori.filimosearch.features.core.data.remote.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(NetworkConstants.TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(NetworkConstants.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(NetworkConstants.TIMEOUT, TimeUnit.SECONDS)
        httpClient.addInterceptor(HeaderInterceptor())
        httpClient.addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                }
        )
        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideFilimoApi(client: OkHttpClient): FilimoApi {
        return Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl(NetworkConstants.BASE_URL)
            .client(client)
            .build()
            .create(FilimoApi::class.java)
    }
}
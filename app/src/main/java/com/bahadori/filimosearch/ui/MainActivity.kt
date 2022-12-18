package com.bahadori.filimosearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bahadori.filimosearch.R
import com.bahadori.filimosearch.features.core.data.remote.FilimoApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.bahadori.filimosearch.features.core.util.common.Constants.TAG
import com.bahadori.filimosearch.features.search.data.repository.SearchRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var api: FilimoApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val searchResult = SearchRepositoryImpl(api).search("yaqi")
            Log.i(TAG, "onCreate: ${searchResult.isSuccess}")
        }
    }
}
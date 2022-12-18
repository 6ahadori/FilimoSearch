package com.bahadori.filimosearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bahadori.filimosearch.R
import com.bahadori.filimosearch.features.core.data.remote.FilimoApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.bahadori.filimosearch.features.core.util.common.Constants.TAG
import com.bahadori.filimosearch.features.core.util.common.Resource
import com.bahadori.filimosearch.features.search.data.repository.SearchRepositoryImpl
import com.bahadori.filimosearch.features.search.domain.usecase.Search
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var search: Search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            search("yaqi").onEach { resource ->
                when (resource) {
                    is Resource.Error -> {
                        Log.i(TAG, "Error: ${resource.message}")
                    }
                    is Resource.Loading -> {
                        Log.i(TAG, "Loading... ")
                    }
                    is Resource.Success -> {
                        Log.i(TAG, "Success: ${resource.data?.size} items")
                    }
                }
            }.launchIn(this)
        }
    }
}
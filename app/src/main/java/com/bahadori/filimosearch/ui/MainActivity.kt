package com.bahadori.filimosearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bahadori.filimosearch.R
import com.bahadori.filimosearch.databinding.ActivityMainBinding
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


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}
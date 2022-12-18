package com.bahadori.filimosearch.features.search.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bahadori.filimosearch.databinding.FragmentSearchBinding
import com.bahadori.filimosearch.features.core.util.common.Constants.TAG
import com.bahadori.filimosearch.features.core.util.common.Utils
import com.bahadori.filimosearch.features.core.util.ext.textChanges
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@FlowPreview
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<SearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = init(inflater, container)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        setupView()
        setupObservers()

        return view
    }

    private fun setupView() {
        binding.greeting.text = getString(Utils.getGreetingMessage())

        binding.searchBar.textChanges()
            .debounce(300)
            .onEach { query ->
                viewModel.onEvent(SearchEvent.OnQueryChanged(query.toString()))
            }.launchIn(lifecycleScope)
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->

                    Log.i(TAG, "setupObservers: ${state.movies?.data?.size} items found")
                }
            }
        }
    }
}
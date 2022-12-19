package com.bahadori.filimosearch.features.search.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.bahadori.filimosearch.databinding.FragmentSearchBinding
import com.bahadori.filimosearch.features.core.util.common.Constants.TAG
import com.bahadori.filimosearch.features.core.util.common.Resource
import com.bahadori.filimosearch.features.core.util.common.Utils
import com.bahadori.filimosearch.features.core.util.ext.hide
import com.bahadori.filimosearch.features.core.util.ext.show
import com.bahadori.filimosearch.features.core.util.ext.showMessage
import com.bahadori.filimosearch.features.core.util.ext.textChanges
import com.bahadori.filimosearch.features.search.domain.model.Data
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@FlowPreview
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class SearchFragment : Fragment(), MovieAdapter.Interaction {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<SearchViewModel>()

    @Inject
    lateinit var adapter: MovieAdapter

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
        binding.recyclerView.apply {
            adapter = this@SearchFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), 3)
        }

        binding.searchBar.textChanges()
            .debounce(300)
            .onEach { query ->
                if (query.isNullOrBlank()) adapter.submitList(emptyList())
                viewModel.onEvent(SearchEvent.OnQueryChanged(query.toString()))
            }.launchIn(lifecycleScope)
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    state.movies.let { resource ->
                        binding.empty.hide()
                        binding.loading.hide()
                        binding.initialState.hide()
                        adapter.submitList(resource?.data ?: emptyList())
                        when (resource) {
                            is Resource.Error -> {
                                requireActivity().showMessage(resource.message)
                            }
                            is Resource.Loading -> {
                                binding.loading.show()
                            }
                            is Resource.Success -> {
                                if (resource.data.isNullOrEmpty()) {
                                    binding.empty.show()
                                }
                            }
                            else -> {
                                binding.initialState.show()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onMovieClicked(movie: Data) {

    }
}
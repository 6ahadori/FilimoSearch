package com.bahadori.filimosearch.features.search.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.bahadori.filimosearch.R
import com.bahadori.filimosearch.databinding.FragmentSearchBinding
import com.bahadori.filimosearch.features.core.util.common.Resource
import com.bahadori.filimosearch.features.core.util.common.ScreenUtils
import com.bahadori.filimosearch.features.core.util.ext.*
import com.bahadori.filimosearch.features.search.domain.model.Data
import com.bahadori.filimosearch.features.theme.domain.model.Theme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt


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
            layoutManager = GridLayoutManager(requireContext(), calculateSpanCount())
        }

        binding.searchBar.textChanges()
            .debounce(300)
            .onEach { query ->
                if (query.isNullOrBlank()) adapter.submitList(emptyList())
                viewModel.onEvent(SearchEvent.OnQueryChanged(query.toString()))
            }.launchIn(lifecycleScope)

        binding.searchBar.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                requireActivity().hideKeyboard()
                return@OnEditorActionListener true
            }
            false
        })

        binding.theme.setOnClickListener {
            when (viewModel.theme.value) {
                Theme.Day -> viewModel.onEvent(SearchEvent.SetTheme(Theme.Night))
                Theme.Night -> viewModel.onEvent(SearchEvent.SetTheme(Theme.Day))
            }
        }
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.theme.collect { theme ->
                        when (theme) {
                            Theme.Day -> {
                                binding.theme.setImageResource(R.drawable.ic_moon)
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            }
                            Theme.Night -> {
                                binding.theme.setImageResource(R.drawable.ic_sun)
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            }
                        }
                    }
                }
                launch {
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
    }

    private fun calculateSpanCount(): Int {
        val dpWidth: Float = ScreenUtils.getScreenWidth() /
                ScreenUtils.getDisplayMetrics(requireContext()).density
        return (dpWidth / 120).roundToInt()
    }

    override fun onMovieClicked(movie: Data) {

    }
}
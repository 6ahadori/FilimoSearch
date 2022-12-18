package com.bahadori.filimosearch.features.search.domain.usecase

import com.bahadori.filimosearch.features.core.data.remote.NetworkConstants
import com.bahadori.filimosearch.features.core.util.common.Resource
import com.bahadori.filimosearch.features.search.domain.model.Data
import com.bahadori.filimosearch.features.search.domain.repository.SearchRepository
import kotlinx.coroutines.flow.flow
import java.lang.NullPointerException

class Search(
    private val searchRepository: SearchRepository
) {

    operator fun invoke(query: String?) = flow<Resource<List<Data>>> {
        try {
            if (query == null) throw NullPointerException("برای جستجو عبارتی را وارد کنید.")
            emit(Resource.Loading())
            val result = searchRepository.search(query)
            if (result.isSuccess) {
                val data = result.getOrNull()?.data?.filterNotNull() ?: listOf()
                emit(Resource.Success(data))
            } else {
                emit(
                    Resource.Error(
                        result.exceptionOrNull()?.message ?: NetworkConstants.UNKNOWN_ERROR
                    )
                )
            }
        } catch (e: Throwable) {
            emit(Resource.Error(e.message ?: NetworkConstants.UNKNOWN_ERROR))
        }
    }
}
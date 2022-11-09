package com.kola.basic.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kola.basic.data.local.room.tables.SampleEntity
import com.kola.basic.data.network.response.SampleModels
import com.kola.basic.repository.SampleRepository
import com.kola.basic.util.emitFlowResults
import com.kola.basic.util.generics.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val sampleRepository: SampleRepository
): ViewModel() {

    private val _sampleResponse: MutableLiveData<DataState<List<SampleModels>>> = MutableLiveData()
    val sampleResponse: LiveData<DataState<List<SampleModels>>> get() = _sampleResponse

    fun getSample() = emitFlowResults(_sampleResponse) {
        sampleRepository.sampleRepository()
    }

    suspend fun insertSample(sampleEntity: SampleEntity) = viewModelScope.launch() {
        sampleRepository.insertData (sampleEntity)
    }
}
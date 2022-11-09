package com.kola.basic.repository

import com.kola.basic.data.local.room.LocalDao
import com.kola.basic.data.local.room.tables.SampleEntity
import com.kola.basic.data.network.response.SampleModels
import com.kola.basic.data.network.NetworkApi
import com.kola.basic.util.generics.DataState
import com.kola.basic.util.processDataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SampleRepository @Inject constructor(
    private val networkApi: NetworkApi,
    private val localDao: LocalDao
){
     fun sampleRepository(): Flow<DataState<List<SampleModels>>> {
        return processDataState { networkApi.getSample() }
    }

    suspend fun insertData(sampleEntity: SampleEntity) {
        localDao.insertSample(sampleEntity)
    }
}
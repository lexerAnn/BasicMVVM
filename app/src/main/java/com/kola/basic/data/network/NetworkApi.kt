package com.kola.basic.data.network

import com.kola.basic.data.network.response.SampleModels
import retrofit2.Response
import retrofit2.http.*

interface NetworkApi {

    @GET("posts")
    suspend fun getSample(): Response<List<SampleModels>>

}
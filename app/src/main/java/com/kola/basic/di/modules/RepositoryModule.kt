package com.kola.basic.di.modules

import com.kola.basic.data.local.room.LocalDao
import com.kola.basic.data.network.NetworkApi
import com.kola.basic.repository.SampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesSampleRepository(networkApi: NetworkApi, localDao: LocalDao): SampleRepository {
        return SampleRepository(networkApi, localDao)
    }
}
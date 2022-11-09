package com.kola.basic.di.modules

import android.content.Context
import androidx.room.Room
import com.kola.basic.data.local.LocalDatabase
import com.kola.basic.data.local.room.LocalDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideLocalDatabase(@ApplicationContext context: Context): LocalDatabase =
        Room.databaseBuilder(
            context,
            LocalDatabase::class.java,
            LocalDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideLocalDao(localDatabase: LocalDatabase): LocalDao =
        localDatabase.localDao()
}
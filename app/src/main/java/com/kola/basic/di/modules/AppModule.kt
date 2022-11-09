package com.kola.basic.di.modules

import android.content.Context
import android.provider.Settings
import com.kola.basic.data.local.preferences.SharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesSharedPrefs(@ApplicationContext context: Context): SharedPref = SharedPref(context)

    @Singleton
    @Provides
    @Named("deviceId")
    fun provideAndroidId(@ApplicationContext context: Context): String =
        Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
}
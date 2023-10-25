package com.weatherapp.prayerapp.namazapp.di

import com.weatherapp.prayerapp.namazapp.Api.PrayerApi
import com.weatherapp.prayerapp.namazapp.Utilis.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideretrofit():Retrofit{
        return  Retrofit.Builder().baseUrl(Constant.BASEURL).addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Singleton
    @Provides
    fun provideapi(retrofit: Retrofit): PrayerApi {
        return retrofit.create(PrayerApi::class.java)
    }
}
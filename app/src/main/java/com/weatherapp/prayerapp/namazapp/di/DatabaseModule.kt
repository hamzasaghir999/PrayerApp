package com.weatherapp.prayerapp.namazapp.di

import android.content.Context
import androidx.room.Room
import com.weatherapp.prayerapp.namazapp.DB.PrayerDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providedb( @ApplicationContext context:Context):PrayerDb {
        return  Room.databaseBuilder(context,PrayerDb::class.java,"PrayerDb").build()

    }
}
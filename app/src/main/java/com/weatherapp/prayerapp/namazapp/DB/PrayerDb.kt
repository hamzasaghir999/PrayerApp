package com.weatherapp.prayerapp.namazapp.DB



import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.weatherapp.prayerapp.namazapp.Utilis.Converters
import com.weatherapp.prayerapp.namazapp.model.Prayer


@Database(entities = [Prayer::class], version = 1 )
@TypeConverters(Converters::class)
 abstract  class PrayerDb:RoomDatabase(){
    abstract fun getprayerdao():PrayerDao
}
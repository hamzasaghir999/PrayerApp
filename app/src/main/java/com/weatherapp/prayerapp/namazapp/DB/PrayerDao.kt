package com.weatherapp.prayerapp.namazapp.DB


import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.weatherapp.prayerapp.namazapp.model.Prayer


@Dao
interface PrayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addprayer(prayer: List<Prayer>)
    @Query("SELECT * FROM Prayer")
    suspend fun getprayer():List<Prayer>
}
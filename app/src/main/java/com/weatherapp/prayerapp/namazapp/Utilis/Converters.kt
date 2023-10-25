package com.weatherapp.prayerapp.namazapp.Utilis


import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.weatherapp.prayerapp.namazapp.model.PrayerData

import java.lang.reflect.Type


object Converters {
    @TypeConverter
    fun fromString(value: String?): ArrayList<PrayerData> {
        val listType: Type = object : TypeToken<ArrayList<PrayerData?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<PrayerData?>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
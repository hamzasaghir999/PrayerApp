package com.weatherapp.prayerapp.namazapp.Api


import com.weatherapp.prayerapp.namazapp.model.Prayer
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PrayerApi {
    @GET("calendar/{year}/{month}")
    suspend fun getprayer(
        @Path("year") year: Int,
        @Path("month") month: Int,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("method") method: Int
    ):Response<Prayer>
}
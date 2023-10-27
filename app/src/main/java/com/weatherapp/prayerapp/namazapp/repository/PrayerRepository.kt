package com.weatherapp.prayerapp.namazapp.repository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.weatherapp.prayerapp.namazapp.Api.PrayerApi
import com.weatherapp.prayerapp.namazapp.DB.PrayerDb
import com.weatherapp.prayerapp.namazapp.model.Prayer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class PrayerRepository @Inject constructor(private val prayerApi: PrayerApi,private val prayerDb: PrayerDb) {

    val _ourprayer=MutableLiveData<List<Prayer>>()
    val ourprayer:LiveData<List<Prayer>>
    get()=_ourprayer
init {
    getprayerfromdb()
}

fun getandsaveprayer(year: Int, month: Int, latitude: Double, longitude: Double, method: Int){
    var list= arrayListOf<Prayer>()
      CoroutineScope(Dispatchers.IO).launch {
          CoroutineScope(Dispatchers.IO).async{
              var result=  prayerApi.getprayer(year,month,latitude,longitude,method)
              if(result.isSuccessful && result.body()!=null){
                  list.add(result.body()!!)
                  prayerDb.getprayerdao().addprayer(list)
                  print("this is result of prayer  ${result.body()!!.data}")
                  Log.i("TAG", "getandsaveprayer: fgg  ${result.body()!!}")
             //_ourprayer.postValue(list)
              }
          }.await()
      }

     }

    fun getprayerfromdb(){
     CoroutineScope(Dispatchers.IO).launch {
         val list= prayerDb.getprayerdao().getprayer()
         _ourprayer.postValue(list)
     }

    }
}
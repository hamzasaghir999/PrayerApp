package com.weatherapp.prayerapp.namazapp.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weatherapp.prayerapp.namazapp.model.Prayer
import com.weatherapp.prayerapp.namazapp.repository.PrayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class PrayerViewModel @Inject constructor(private  val prayerRepository: PrayerRepository):ViewModel() {
    val prayerlist: LiveData<List<Prayer>> get() =prayerRepository.ourprayer
   fun getprayers(year: Int, month: Int, latitude: Double, longitude: Double, method: Int){
       prayerRepository.getandsaveprayer(year,month,latitude,longitude,method)
   }

}
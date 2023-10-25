package com.weatherapp.prayerapp.namazapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.weatherapp.prayerapp.namazapp.databinding.ActivityMainBinding
import com.weatherapp.prayerapp.namazapp.model.Prayer
import com.weatherapp.prayerapp.namazapp.model.PrayerData
import com.weatherapp.prayerapp.namazapp.viewModel.PrayerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewmodels:PrayerViewModel
    private lateinit var binding:ActivityMainBinding
    val dateFormat = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
    val currentDate = dateFormat.format(Date()) // Get the current date in the format "dd-MM-yyyy"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodels=ViewModelProvider(this).get(PrayerViewModel::class.java)

        viewmodels.getprayers(2023,10,32.940548,73.727629,2)
        viewmodels.prayerlist.observe(this, Observer {
            Log.i("TAG", "onCreate: fdgfd  ${it.size}")
            val selectedPrayer: Prayer = it[0] // You can replace [0] with the index you need
            Log.i("TAG", "onCreate: cvx $currentDate")
// Access the first PrayerData object from the data list (you can replace [0] with the index you need)
            val firstPrayerData: PrayerData = selectedPrayer.data[0]
            val filteredList = selectedPrayer.data.filter {
                Toast.makeText(this,"dfsdfd ${it.date?.readable} ${currentDate}",Toast.LENGTH_LONG).show()
                it.date?.readable == currentDate }
          Toast.makeText(this,"Hello this is date ${filteredList} $currentDate",Toast.LENGTH_LONG).show()
            selectedPrayer.data.forEach {
                if (it.date?.readable==currentDate){
                    //Toast.makeText(this,"Hello this is date ${it.date?.readable} $currentDate",Toast.LENGTH_LONG).show()
                    binding.fajar.text= it.date?.readable+"  "+it.timings?.Fajr +" "+it.timings?.Dhuhr+" "+it.timings?.Asr +it.timings?.Imsak + ""+it.timings?.Maghrib
                }else{
                    // Toast.makeText(this,"current time ${it.date?.readable} ",Toast.LENGTH_LONG).show()
                    binding.fajar.text= it.date?.readable+"  "+it.timings?.Fajr +" "+it.timings?.Dhuhr+" "+it.timings?.Asr +it.timings?.Imsak + ""+it.timings?.Maghrib
                }

            }
// Access the Fajr timing from the selected PrayerData
            val fajrTiming: String? = firstPrayerData.timings?.Fajr
            //  binding.fajar.text=fajrTiming
        })
    }
}
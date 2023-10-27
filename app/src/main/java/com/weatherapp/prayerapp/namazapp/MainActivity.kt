package com.weatherapp.prayerapp.namazapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.weatherapp.prayerapp.namazapp.databinding.ActivityMainBinding
import com.weatherapp.prayerapp.namazapp.model.Prayer
import com.weatherapp.prayerapp.namazapp.viewModel.PrayerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewmodels: PrayerViewModel
    private lateinit var binding: ActivityMainBinding
    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    var currentDate = dateFormat.format(Date()) // Get the current date in the format "dd MMM yyyy"
    var dateOffset = 0 // Initialize the date offset
    // Get the current year and month
    val calendar = Calendar.getInstance()
    val currentYear = calendar.get(Calendar.YEAR)
    val currentMonth = calendar.get(Calendar.MONTH) + 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodels = ViewModelProvider(this).get(PrayerViewModel::class.java)

        // Add button click listeners
        binding.btnYesterday.setOnClickListener {
            dateOffset--
            displayPrayerTimings()
        }

        binding.btnTomorrow.setOnClickListener {
            dateOffset++
            displayPrayerTimings()
        }
        Log.i("TAG", "onCreate:sdfgh ${currentDate} ${currentMonth} ${currentYear} ")
        viewmodels.getprayers(currentYear, currentMonth, 32.940548, 73.727629, 2)
        viewmodels.prayerlist.observe(this, { prayers ->
            displayPrayerTimings()
        })
    }

//    private fun displayPrayerTimings() {
//        val currentDateInMillis = System.currentTimeMillis() + (dateOffset * 24 * 60 * 60 * 1000)
//        currentDate = dateFormat.format(Date(currentDateInMillis))
//
//        val selectedPrayer = viewmodels.prayerlist.value?.find {
//            it.data.any { it.date?.readable == currentDate }
//        }
//
//        val todayPrayerData = selectedPrayer?.data?.find { it.date?.readable == currentDate }
//        val prayerTimings = todayPrayerData?.timings
//
//        if (todayPrayerData != null && prayerTimings != null) {
//            val prayerTimingsText = "${prayerTimings.Fajr} ${prayerTimings.Dhuhr} " +
//                    "${prayerTimings.Asr} ${prayerTimings.Imsak} ${prayerTimings.Maghrib}"
//            binding.fajar.text = "$currentDate $prayerTimingsText"
//        } else {
//            Toast.makeText(this, "No data found for $currentDate", Toast.LENGTH_LONG).show()
//        }
//    }

    private fun displayPrayerTimings() {
        val currentDateInMillis = System.currentTimeMillis() + (dateOffset * 24 * 60 * 60 * 1000)
        currentDate = dateFormat.format(Date(currentDateInMillis))

        val isDateInDataRange = viewmodels.prayerlist.value?.any { prayer ->
            prayer.data.any { it.date?.readable == currentDate }
        }

        if (isDateInDataRange == true) {
            val selectedPrayer = viewmodels.prayerlist.value?.find {
                it.data.any { it.date?.readable == currentDate }
            }

            val todayPrayerData = selectedPrayer?.data?.find { it.date?.readable == currentDate }
            val prayerTimings = todayPrayerData?.timings

            if (todayPrayerData != null && prayerTimings != null) {
                val prayerTimingsText = "${prayerTimings.Fajr} ${prayerTimings.Dhuhr} " +
                        "${prayerTimings.Asr} ${prayerTimings.Imsak} ${prayerTimings.Maghrib}"
                binding.fajar.text = "$currentDate $prayerTimingsText"
            }
        } else {
            Toast.makeText(this, "No data found for $currentDate", Toast.LENGTH_LONG).show()
        }
    }

}

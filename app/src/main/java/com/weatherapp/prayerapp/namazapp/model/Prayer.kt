package com.weatherapp.prayerapp.namazapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

import com.google.gson.annotations.SerializedName
import com.weatherapp.prayerapp.namazapp.Utilis.Converters

@Entity
data class Prayer (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("code"   ) var code   : Int?            = null,
    @SerializedName("status" ) var status : String?         = null,
    @TypeConverters(Converters::class)
    @SerializedName("data"  ) var data   : ArrayList<PrayerData> = arrayListOf()

)

data class PrayerData (

    @SerializedName("timings" ) var timings : Timings? = Timings(),
    @SerializedName("date"    ) var date    : Date?    = Date(),
    @SerializedName("meta"    ) var meta    : Meta?    = Meta()

)

data class Meta (

    @SerializedName("latitude"                 ) var latitude                 : Double? = null,
    @SerializedName("longitude"                ) var longitude                : Double? = null,
    @SerializedName("timezone"                 ) var timezone                 : String? = null,
    @SerializedName("method"                   ) var method                   : Method? = Method(),
    @SerializedName("latitudeAdjustmentMethod" ) var latitudeAdjustmentMethod : String? = null,
    @SerializedName("midnightMode"             ) var midnightMode             : String? = null,
    @SerializedName("school"                   ) var school                   : String? = null,
    @SerializedName("offset"                   ) var offset                   : Offset? = Offset()

)
data class Offset (

    @SerializedName("Imsak"    ) var Imsak    : Int? = null,
    @SerializedName("Fajr"     ) var Fajr     : Int? = null,
    @SerializedName("Sunrise"  ) var Sunrise  : Int? = null,
    @SerializedName("Dhuhr"    ) var Dhuhr    : Int? = null,
    @SerializedName("Asr"      ) var Asr      : Int? = null,
    @SerializedName("Maghrib"  ) var Maghrib  : Int? = null,
    @SerializedName("Sunset"   ) var Sunset   : Int? = null,
    @SerializedName("Isha"     ) var Isha     : Int? = null,
    @SerializedName("Midnight" ) var Midnight : Int? = null

)
data class Method (

    @SerializedName("id"       ) var id       : Int?      = null,
    @SerializedName("name"     ) var name     : String?   = null,
    @SerializedName("params"   ) var params   : Params?   = Params(),
    @SerializedName("location" ) var location : Location? = Location()

)

data class Location (

    @SerializedName("latitude"  ) var latitude  : Double? = null,
    @SerializedName("longitude" ) var longitude : Double? = null

)
data class Params (

    @SerializedName("Fajr" ) var Fajr : Int? = null,
    @SerializedName("Isha" ) var Isha : Int? = null

)
data class Date (

    @SerializedName("readable"  ) var readable  : String?    = null,
    @SerializedName("timestamp" ) var timestamp : String?    = null,
    @SerializedName("gregorian" ) var gregorian : Gregorian? = Gregorian(),
    @SerializedName("hijri"     ) var hijri     : hijri?     = hijri()

)

data class hijri (

    @SerializedName("date"        ) var date        : String?           = null,
    @SerializedName("format"      ) var format      : String?           = null,
    @SerializedName("day"         ) var day         : String?           = null,
    @SerializedName("weekday"     ) var weekday     : Weekday?          = Weekday(),
    @SerializedName("month"       ) var month       : Month?            = Month(),
    @SerializedName("year"        ) var year        : String?           = null,
    @SerializedName("designation" ) var designation : Designation?      = Designation(),
    @SerializedName("holidays"    ) var holidays    : ArrayList<String> = arrayListOf()

)
data class Designation (

    @SerializedName("abbreviated" ) var abbreviated : String? = null,
    @SerializedName("expanded"    ) var expanded    : String? = null

)
data class Month (

    @SerializedName("number" ) var number : Int?    = null,
    @SerializedName("en"     ) var en     : String? = null,
    @SerializedName("ar"     ) var ar     : String? = null

)

data class Weekday (

    @SerializedName("en" ) var en : String? = null,
    @SerializedName("ar" ) var ar : String? = null

)

data class Gregorian (

    @SerializedName("date"        ) var date        : String?      = null,
    @SerializedName("format"      ) var format      : String?      = null,
    @SerializedName("day"         ) var day         : String?      = null,
    @SerializedName("weekday"     ) var weekday     : Weekday?     = Weekday(),
    @SerializedName("month"       ) var month       : Month?       = Month(),
    @SerializedName("year"        ) var year        : String?      = null,
    @SerializedName("designation" ) var designation : Designation? = Designation()

)
data class Timings (

    @SerializedName("Fajr"       ) var Fajr       : String? = null,
    @SerializedName("Sunrise"    ) var Sunrise    : String? = null,
    @SerializedName("Dhuhr"      ) var Dhuhr      : String? = null,
    @SerializedName("Asr"        ) var Asr        : String? = null,
    @SerializedName("Sunset"     ) var Sunset     : String? = null,
    @SerializedName("Maghrib"    ) var Maghrib    : String? = null,
    @SerializedName("Isha"       ) var Isha       : String? = null,
    @SerializedName("Imsak"      ) var Imsak      : String? = null,
    @SerializedName("Midnight"   ) var Midnight   : String? = null,
    @SerializedName("Firstthird" ) var Firstthird : String? = null,
    @SerializedName("Lastthird"  ) var Lastthird  : String? = null

)
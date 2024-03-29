package com.sagar.nourishnow.data.offline.converters

import androidx.room.TypeConverter
import com.squareup.moshi.Json
import java.util.Date

class DateTypeConverter {
    @TypeConverter
    fun fromDate(date: Date): Long{
        return date.time
    }

    @TypeConverter
    fun toDate(date: Long): Date{
        return Date(date)
    }
}
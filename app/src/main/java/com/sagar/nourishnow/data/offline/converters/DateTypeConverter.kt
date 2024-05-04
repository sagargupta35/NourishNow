package com.sagar.nourishnow.data.offline.converters

import androidx.room.TypeConverter
import com.squareup.moshi.Json
import java.time.LocalDate
import java.util.Date
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Local

class DateTypeConverter {
    @TypeConverter
    fun fromDate(date: LocalDate?): String?{
        return date?.toString()
    }

    @TypeConverter
    fun toLocalDate(dateString: String?): LocalDate? {
        return dateString?.let { LocalDate.parse(it) }
    }

}
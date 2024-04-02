package com.sagar.nourishnow.data.offline.converters

import androidx.room.TypeConverter
import com.sagar.nourishnow.domain.model.MeasuringUnit

/**
 *Conversion is achieved by just taking the symbol of the unit as actual class can
 * be obtained with the help of the symbol alone
 */

class MeasuringUnitTypeConverter {

    @TypeConverter
    fun fromString(unit: String?): MeasuringUnit {
        return MeasuringUnit.getUnit(unit)
    }

    @TypeConverter
    fun toString(unit: MeasuringUnit): String {
        return unit.symbol
    }
}
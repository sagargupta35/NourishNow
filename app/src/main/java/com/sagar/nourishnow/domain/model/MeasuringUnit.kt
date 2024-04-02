package com.sagar.nourishnow.domain.model


/**
 * The conversion is achieved via milligram i.e., every unit is first
 * converted to milligram and then to the other unit.
 * the NULL_UNIT is just a safe unit to avoid nulls and unknown units
 */

enum class MeasuringUnit(val symbol: String, val conversionFactor: Double) {
    KG("kg", 1000000.toDouble()),
    GRAMS("g", 1000.toDouble()),
    MG("mg", 1.toDouble()),
    MICROGRAMS("µg", 0.001),
    NULL_UNIT("null", 0.0);
    companion object {
        fun convert(from: MeasuringUnit, to: MeasuringUnit): Pair<MeasuringUnit, Double>{
            if(to == NULL_UNIT || from == NULL_UNIT) return Pair(NULL_UNIT, 0.toDouble())
            return Pair(to, from.conversionFactor / to.conversionFactor)
        }

        fun getUnit(symbol: String?): MeasuringUnit{
            return entries.firstOrNull { unit ->
                unit.symbol == symbol
            } ?: NULL_UNIT
        }
    }
}
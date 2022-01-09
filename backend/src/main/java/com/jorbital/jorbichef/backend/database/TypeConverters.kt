package com.jorbital.jorbichef.backend.database

import androidx.room.TypeConverter
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSerializationApi::class)
class StringListConverter {
    @TypeConverter
    fun stringToListOfStrings(data: String?): List<String> {
        if (data == null) {
            return emptyList()
        }
        return Json.decodeFromString(data)
    }

    @TypeConverter
    fun listOfStringsToString(data: List<String>): String {
        return Json.encodeToString(data)
    }
}
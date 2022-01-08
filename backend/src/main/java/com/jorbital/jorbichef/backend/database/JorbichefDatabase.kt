package com.jorbital.jorbichef.backend.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jorbital.jorbichef.backend.database.daos.RecipeDao
import com.jorbital.jorbichef.backend.database.entities.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 1)
abstract class JorbichefDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}
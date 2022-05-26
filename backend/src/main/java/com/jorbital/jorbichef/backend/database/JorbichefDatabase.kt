package com.jorbital.jorbichef.backend.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jorbital.jorbichef.backend.database.entities.IngredientDao
import com.jorbital.jorbichef.backend.database.entities.IngredientEntity
import com.jorbital.jorbichef.backend.database.entities.RecipeDao
import com.jorbital.jorbichef.backend.database.entities.RecipeEntity
import com.jorbital.jorbichef.backend.database.entities.TagDao
import com.jorbital.jorbichef.backend.database.entities.TagEntity
import com.jorbital.jorbichef.backend.database.entities.UserDao
import com.jorbital.jorbichef.backend.database.entities.UserEntity
import com.jorbital.jorbichef.backend.database.typeconverters.StringListConverter

@Database(
    entities = [UserEntity::class,
        IngredientEntity::class,
        TagEntity::class,
        RecipeEntity::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(
    StringListConverter::class
)
abstract class JorbichefDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun ingredientDao(): IngredientDao
    abstract fun tagDao(): TagDao
    abstract fun recipeDao(): RecipeDao
}

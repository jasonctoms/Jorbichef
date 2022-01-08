package com.jorbital.jorbichef.backend.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jorbital.jorbichef.backend.database.entities.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe")
    fun getAll(): Flow<List<RecipeEntity>>

    @Insert
    fun insertAll(vararg recipes: RecipeEntity)

    @Delete
    fun delete(recipe: RecipeEntity)
}
package com.jorbital.jorbichef.backend.database.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "ingredient")
data class IngredientEntity(
    @PrimaryKey val id: String,
    val name: String,
    val isCustom: Boolean
)

@Dao
interface IngredientDao {
    @Query("SELECT * FROM ingredient")
    fun getAll(): Flow<List<IngredientEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(ingredients: List<IngredientEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ingredient: IngredientEntity)

    @Delete
    fun delete(ingredient: IngredientEntity)
}
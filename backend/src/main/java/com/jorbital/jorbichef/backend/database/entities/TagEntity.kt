package com.jorbital.jorbichef.backend.database.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "tag")
data class TagEntity(
    @PrimaryKey val id: String,
    val name: String,
    val isCustom: Boolean
)

@Dao
interface TagDao {
    @Query("SELECT * FROM tag")
    fun getAll(): Flow<List<TagEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(tags: List<TagEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tag: TagEntity)

    @Delete
    fun delete(tag: TagEntity)
}

package com.jorbital.jorbichef.backend.database.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: Int = 0,
    val sharedUsers: List<String>
)

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE id like 0")
    suspend fun get(): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)
}
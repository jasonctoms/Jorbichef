package com.jorbital.jorbichef.backend

import androidx.room.Room
import com.jorbital.jorbichef.backend.database.JorbichefDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val backendKoinModule = module {
    single {
        Room.databaseBuilder(androidApplication(), JorbichefDatabase::class.java, "JorbichefDatabase")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<JorbichefDatabase>().recipeDao() }
}
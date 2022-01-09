package com.jorbital.jorbichef.backend

import androidx.room.Room
import com.jorbital.jorbichef.backend.database.JorbichefDatabase
import com.jorbital.jorbichef.backend.firebase.FirestoreService
import com.jorbital.jorbichef.backend.repository.SyncRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val backendKoinModule = module {
    single {
        Room.databaseBuilder(androidApplication(), JorbichefDatabase::class.java, "JorbichefDatabase")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<JorbichefDatabase>().userDao() }
    single { get<JorbichefDatabase>().ingredientDao() }
    single { get<JorbichefDatabase>().tagDao() }
    single { get<JorbichefDatabase>().recipeDao() }

    single { FirestoreService() }

    factory { SyncRepository(get(), get(), get(), get(), get()) }
}
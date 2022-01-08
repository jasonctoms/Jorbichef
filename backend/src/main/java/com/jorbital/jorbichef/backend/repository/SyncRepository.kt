package com.jorbital.jorbichef.backend.repository

import com.jorbital.jorbichef.backend.firebase.DefaultIngredientDocument
import com.jorbital.jorbichef.backend.firebase.FirestoreService
import kotlinx.coroutines.flow.flow
import timber.log.Timber

class SyncRepository(private val firestoreService: FirestoreService) {
    val getDefaultIngredients = flow {
        firestoreService.getDefaultIngredients.collect { result ->
            val documents = result.getOrElse { Timber.e(it) } as List<DefaultIngredientDocument>
            emit(documents)
        }
    }
}
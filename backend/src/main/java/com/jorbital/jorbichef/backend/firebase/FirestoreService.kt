package com.jorbital.jorbichef.backend.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class FirestoreService {
    private val firestore by lazy { Firebase.firestore }
    private val currentUserId by lazy { FirebaseAuth.getInstance().currentUser?.uid }

    val getDefaultIngredients = flow {
        val snapshot = firestore.collection(DEFAULT_INGREDIENTS_COLLECTION).get().await()
        val defaultIngredients = mutableListOf<DefaultIngredientDocument>()
        for (document in snapshot) {
            val ingredient = document.toObject(DefaultIngredientDocument::class.java).copy(id = document.id)
            defaultIngredients.add(ingredient)
        }
        emit(Result.success(defaultIngredients))
    }.catch {
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)

    companion object {
        const val DEFAULT_INGREDIENTS_COLLECTION = "defaultIngredients"
        const val DEFAULT_TAGS_COLLECTION = "defaultTags"
        const val USERS_COLLECTION = "users"
        const val CUSTOM_INGREDIENTS_COLLECTION = "ingredients"
        const val CUSTOM_TAGS_COLLECTION = "tags"
        const val RECIPES_COLLECTION = "recipes"
    }
}
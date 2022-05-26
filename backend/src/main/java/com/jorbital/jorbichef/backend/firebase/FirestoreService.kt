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

    val getDefaultTags = flow {
        val snapshot = firestore.collection(DEFAULT_TAGS_COLLECTION).get().await()
        val defaultTags = mutableListOf<DefaultTagDocument>()
        for (document in snapshot) {
            val tag = document.toObject(DefaultTagDocument::class.java).copy(id = document.id)
            defaultTags.add(tag)
        }
        emit(Result.success(defaultTags))
    }.catch {
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)

    val getCustomIngredients = flow {
        currentUserId?.let { userId ->
            val snapshot = firestore.collection(USERS_COLLECTION).document(userId).collection(CUSTOM_INGREDIENTS_COLLECTION).get().await()
            val customIngredients = mutableListOf<CustomIngredientDocument>()
            for (document in snapshot) {
                val ingredient = document.toObject(CustomIngredientDocument::class.java).copy(id = document.id)
                customIngredients.add(ingredient)
            }
            emit(Result.success(customIngredients))
        }
    }.catch {
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)

    val getCustomTags = flow {
        currentUserId?.let { userId ->
            val snapshot = firestore.collection(USERS_COLLECTION).document(userId).collection(CUSTOM_TAGS_COLLECTION).get().await()
            val customTags = mutableListOf<CustomTagDocument>()
            for (document in snapshot) {
                val tag = document.toObject(CustomTagDocument::class.java).copy(id = document.id)
                customTags.add(tag)
            }
            emit(Result.success(customTags))
        }
    }.catch {
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)

    val getRecipes = flow {
        currentUserId?.let { userId ->
            val snapshot = firestore.collection(USERS_COLLECTION).document(userId).collection(RECIPES_COLLECTION).get().await()
            val recipes = mutableListOf<RecipeDocument>()
            for (document in snapshot) {
                val recipe = document.toObject(RecipeDocument::class.java).copy(id = document.id)
                recipes.add(recipe)
            }
            emit(Result.success(recipes))
        }
    }.catch {
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)

    val getSharedUsers = flow<Result<List<String>>> {
        currentUserId?.let { userId ->
            val snapshot = firestore.collection(USERS_COLLECTION).document(userId).get().await()
            val userDocument = snapshot.toObject(UserDocument::class.java)
            if (userDocument != null) {
                emit(Result.success(userDocument.sharedUsers))
            } else {
                emit(Result.success(emptyList()))
            }
        }
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
package com.jorbital.jorbichef.backend.repository

import com.jorbital.jorbichef.backend.database.entities.IngredientDao
import com.jorbital.jorbichef.backend.database.entities.RecipeDao
import com.jorbital.jorbichef.backend.database.entities.TagDao
import com.jorbital.jorbichef.backend.database.entities.UserDao
import com.jorbital.jorbichef.backend.database.entities.UserEntity
import com.jorbital.jorbichef.backend.firebase.FirestoreService
import com.jorbital.jorbichef.backend.firebase.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class SyncRepository(
    private val firestoreService: FirestoreService,
    private val ingredientDao: IngredientDao,
    private val tagDao: TagDao,
    private val userDao: UserDao,
    private val recipeDao: RecipeDao
) {
    suspend fun isDatabaseEmpty(): Boolean {
        return userDao.get() == null
    }

    val downloadFromFirestore = flow {
        firestoreService.getDefaultIngredients.collect { result ->
            if (result.isSuccess) {
                result.getOrNull()?.let { documents ->
                    ingredientDao.insertAll(documents.map { it.toEntity() })
                }
            } else {
                Timber.e(result.exceptionOrNull())
            }
        }
        firestoreService.getDefaultTags.collect { result ->
            if (result.isSuccess) {
                result.getOrNull()?.let { documents ->
                    tagDao.insertAll(documents.map { it.toEntity() })
                }
            } else {
                Timber.e(result.exceptionOrNull())
            }
        }
        firestoreService.getCustomIngredients.collect { result ->
            if (result.isSuccess) {
                result.getOrNull()?.let { documents ->
                    ingredientDao.insertAll(documents.map { it.toEntity() })
                }
            } else {
                Timber.e(result.exceptionOrNull())
            }
        }
        firestoreService.getCustomTags.collect { result ->
            if (result.isSuccess) {
                result.getOrNull()?.let { documents ->
                    tagDao.insertAll(documents.map { it.toEntity() })
                }
            } else {
                Timber.e(result.exceptionOrNull())
            }
        }
        firestoreService.getRecipes.collect { result ->
            if (result.isSuccess) {
                result.getOrNull()?.let { documents ->
                    recipeDao.insertAll(documents.map { it.toEntity() })
                }
            } else {
                Timber.e(result.exceptionOrNull())
            }
        }
        firestoreService.getSharedUsers.collect { result ->
            if (result.isSuccess) {
                result.getOrNull()?.let {
                    userDao.insert(UserEntity(sharedUsers = it))
                }
            } else {
                Timber.e(result.exceptionOrNull())
            }
        }
        emit(Result.success(true))
    }.catch {
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)
}
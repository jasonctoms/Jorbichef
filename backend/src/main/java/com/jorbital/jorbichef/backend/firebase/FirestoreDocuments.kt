package com.jorbital.jorbichef.backend.firebase

import com.jorbital.jorbichef.backend.database.entities.IngredientEntity
import com.jorbital.jorbichef.backend.database.entities.RecipeEntity
import com.jorbital.jorbichef.backend.database.entities.TagEntity
import java.util.*

data class DefaultIngredientDocument(
    val id: String = "",
    val name: Map<String, String> = emptyMap()
)

fun DefaultIngredientDocument.toEntity(): IngredientEntity {
    val language = when (Locale.getDefault().language) {
        "no", "nn" -> "no"
        else -> "en"
    }
    return IngredientEntity(
        id = this.id,
        name = this.name[language].orEmpty(),
        isCustom = false
    )
}

data class DefaultTagDocument(
    val id: String = "",
    val name: Map<String, String> = emptyMap()
)

fun DefaultTagDocument.toEntity(): TagEntity {
    val language = when (Locale.getDefault().language) {
        "no", "nn" -> "no"
        else -> "en"
    }
    return TagEntity(
        id = this.id,
        name = this.name[language].orEmpty(),
        isCustom = false
    )
}

data class CustomIngredientDocument(
    val id: String = "",
    val name: String = ""
)

fun CustomIngredientDocument.toEntity(): IngredientEntity {
    return IngredientEntity(
        id = this.id,
        name = this.name,
        isCustom = true
    )
}

data class CustomTagDocument(
    val id: String = "",
    val name: String = ""
)

fun CustomTagDocument.toEntity(): TagEntity {
    return TagEntity(
        id = this.id,
        name = this.name,
        isCustom = true
    )
}

data class RecipeDocument(
    val id: String = "",
    val name: String = ""
)

fun RecipeDocument.toEntity(): RecipeEntity {
    return RecipeEntity(
        id = this.id,
        name = this.name
    )
}

data class UserDocument(
    val sharedUsers: List<String> = emptyList()
)

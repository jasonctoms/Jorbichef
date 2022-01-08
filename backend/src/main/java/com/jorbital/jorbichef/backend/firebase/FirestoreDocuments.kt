package com.jorbital.jorbichef.backend.firebase

data class DefaultIngredientDocument(
    val id: String = "",
    val name: Map<String, String> = emptyMap()
)

data class DefaultTagDocument(
    val id: String = "",
    val name: Map<String, String> = emptyMap()
)

data class CustomIngredientDocument(
    val id: String = "",
    val name: String = ""
)

data class CustomTagDocument(
    val id: String = "",
    val name: String = ""
)

data class RecipeDocument(
    val id: String = "",
    val name: String = ""
)

data class UserDocument(
    val sharedUsers: List<String> = emptyList()
)
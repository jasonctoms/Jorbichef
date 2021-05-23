package com.jorbital.jorbichef.network

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import javax.inject.Inject

class ApolloTestClass @Inject constructor() {
    val apolloClient = ApolloClient.builder()
        .serverUrl("http://10.0.2.2:8080/graphql")
        .build()

    suspend fun getIngredients(): List<FetchIngredientsQuery.Ingredient> {
        val response = apolloClient.query(FetchIngredientsQuery()).await()

        val ingredients = response.data?.ingredients
        if (ingredients == null || response.hasErrors()) {
            return emptyList()
        }
        return ingredients
    }
}
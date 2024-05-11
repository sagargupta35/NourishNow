package com.sagar.nourishnow.presentation.display_recipe.use_case

import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.model.Ingredient
import com.sagar.nourishnow.domain.repository.RecipeOfflineRepository
import kotlinx.coroutines.flow.filter
import javax.inject.Inject

class CollectIngredientByIdUseCase @Inject constructor(
    private val recipeOfflineRepository: RecipeOfflineRepository
) {

    suspend fun collectIngredientById(
        ingredientId: Long,
        onIngredientCollect: (Resource<Ingredient>) -> Unit
    ){
        recipeOfflineRepository.getIngredientById(ingredientId)
            .filter { it !is Resource.Loading }
            .collect{
                 onIngredientCollect(it)
            }
    }

}

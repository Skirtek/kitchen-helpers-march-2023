package com.codecool.kitchenmanagement.models.ingredients;

import java.util.Optional;

public interface IngredientsStore {
    Optional<IngredientType> requestIngredient(IngredientType ingredientType);
}

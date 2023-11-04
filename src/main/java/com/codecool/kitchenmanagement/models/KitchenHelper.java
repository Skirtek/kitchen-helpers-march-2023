package com.codecool.kitchenmanagement.models;

import com.codecool.kitchenmanagement.models.ingredients.IngredientType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class KitchenHelper extends Employee {
    private final int MAX_NUMBER_OF_INGREDIENTS = 3;
    private static final Random random = new Random();

    // Meat: 3
    // Potato: 0
    // Carrot: 1
    private Map<IngredientType, Integer> helperIngredients = new HashMap<>();

    public KitchenHelper(String name, LocalDate birthDate, int salary) {
        super(name, birthDate, salary);

        // Meat: 0
        // Potato: 0
        // Carrot: 0
        for (IngredientType ingredientType : IngredientType.values()) {
            helperIngredients.put(ingredientType, 0);
        }
    }

    public void addIngredients() {
        for (IngredientType ingredientType : IngredientType.values()) {
            int ingredientAmount = random.nextInt(MAX_NUMBER_OF_INGREDIENTS + 1);
            helperIngredients.merge(ingredientType, ingredientAmount, Math::max);
        }
    }

    public Optional<IngredientType> giveIngredient(IngredientType ingredientType) {
        boolean hasIngredient = hasIngredient(ingredientType);

        if (hasIngredient) {
            deleteIngredient(ingredientType);

            System.out.println("I'm " + this.getName() + " and I gave you " + ingredientType.toString());

            return Optional.of(ingredientType);
        }

        return Optional.empty();
    }

    public boolean hasIngredient(IngredientType ingredientType) {
        return helperIngredients.get(ingredientType) > 0;
    }

    private void deleteIngredient(IngredientType ingredientType) {
        // Mam 3
        int previousAmount = helperIngredients.get(ingredientType);
        // wydałem jedno
        int newAmount = previousAmount - 1;
        // mam 2
        helperIngredients.replace(ingredientType, newAmount);
    }
}

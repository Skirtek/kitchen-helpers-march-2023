package com.codecool.kitchenmanagement.models.ingredients;

import java.util.Random;

public enum IngredientType {
    MEAT,
    POTATOES,
    CARROT;

    private final static Random random = new Random();

    public static IngredientType getRandomIngredient() {
        IngredientType[] values = IngredientType.values();

        int lengthOfValues = values.length;

        return values[random.nextInt(lengthOfValues)];
    }
}

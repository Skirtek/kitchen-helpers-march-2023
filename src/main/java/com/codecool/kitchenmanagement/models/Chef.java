package com.codecool.kitchenmanagement.models;

import com.codecool.kitchenmanagement.interfaces.Cooking;
import com.codecool.kitchenmanagement.models.ingredients.IngredientType;
import com.codecool.kitchenmanagement.models.ingredients.IngredientsStore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

public class Chef extends Employee implements Cooking {
    private boolean hasKnife;

    private static final Random random = new Random();

    @Getter
    @Setter
    private IngredientsStore ingredientsStore;

    public Chef(String name, LocalDate birthDate, int salary) {
        super(name, birthDate, salary);
    }

    @Override
    public void cook() {
        if (!this.hasKnife) {
            System.out.println("I'm " + this.getName() + " and I can not cook without knife");
            return;
        }

        boolean isRequestingIngredients = random.nextBoolean();

        if (isRequestingIngredients) {
            IngredientType ingredientType = IngredientType.getRandomIngredient();
            System.out.println("I'm chef and I need: " + ingredientType.toString());

            Optional<IngredientType> requestedIngredient = ingredientsStore.requestIngredient(ingredientType);

            String answer = requestedIngredient.map(IngredientType::toString).orElse("nothing");

            System.out.println("I've got " + answer);
        } else {
            System.out.println("Are you cooking morons?");
        }
    }

    @Override
    public void giveKnife() {
        this.hasKnife = true;
    }
}
